package br.juauzitor.smat.infrastructure.persistence;

import br.juauzitor.smat.domain.model.Company;
import br.juauzitor.smat.domain.model.TaskCategory;
import br.juauzitor.smat.domain.model.TaskPerformed;
import br.juauzitor.smat.domain.model.WorkFrequency;
import br.juauzitor.smat.domain.port.out.TaskPerformedRepository;
import br.juauzitor.smat.infrastructure.persistence.entities.JpaCompanyEntity;
import br.juauzitor.smat.infrastructure.persistence.entities.JpaTaskCategoryEntity;
import br.juauzitor.smat.infrastructure.persistence.entities.JpaTaskPerformedEntity;
import br.juauzitor.smat.infrastructure.persistence.entities.JpaWorkFrequencyEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class TaskPerformedRepositoryImpl implements TaskPerformedRepository {
    public final JpaTaskPerformedRepository jpaTaskPerformedRepository;

    public TaskPerformedRepositoryImpl(JpaTaskPerformedRepository jpaTaskPerformedRepository) {
        this.jpaTaskPerformedRepository = jpaTaskPerformedRepository;
    }

    @Override
    public TaskPerformed saveT(TaskPerformed taskPerformed) {
        JpaTaskPerformedEntity taskPerformedEntity = new JpaTaskPerformedEntity(taskPerformed);
        JpaTaskPerformedEntity savedTaskPerformedEntity = jpaTaskPerformedRepository.save(taskPerformedEntity);
        return convertToDomain(savedTaskPerformedEntity);
    }

    @Override
    public Optional<TaskPerformed> readT(UUID id) {
        Optional<JpaTaskPerformedEntity> taskPerformedEntity = this.jpaTaskPerformedRepository.findById(id);
        return taskPerformedEntity.map(this::convertToDomain);
    }

    @Override
    public List<TaskPerformed> readAllT() {
        return this.jpaTaskPerformedRepository.findAll()
        .stream()
        .map(this::convertToDomain)
        .collect(Collectors.toList());
    }

    @Override
    public void updateT(TaskPerformed taskPerformed) {
        if (this.jpaTaskPerformedRepository.existsById(taskPerformed.getTaskPerformedId())) {
            JpaTaskPerformedEntity taskPerformedEntity = new JpaTaskPerformedEntity(taskPerformed);
            this.jpaTaskPerformedRepository.save(taskPerformedEntity);
        } else {
            throw new RuntimeException("Task Performed not found with id: " + taskPerformed.getTaskPerformedId().toString());
        }
    }

    @Override
    public void deleteT(UUID id) {
        this.jpaTaskPerformedRepository.deleteById(id);
    }

    public TaskPerformed convertToDomain(JpaTaskPerformedEntity entity){
        return new TaskPerformed(
                entity.getTaskPerformedId(),
                convertCompany(entity.getCompany()),
                convertTaskCategory(entity.getTaskCategory()),
                convertWorkFrequency(entity.getWorkFrequency()),
                entity.getDescription()
        );
    }

    public Company convertCompany(JpaCompanyEntity entity){
        return new Company(entity.getCompanyId(), entity.getCompanyName());
    }

    public TaskCategory convertTaskCategory(JpaTaskCategoryEntity entity){
        return new TaskCategory(entity.getTaskCategoryId(), entity.getCategoryName());
    }

    public WorkFrequency convertWorkFrequency(JpaWorkFrequencyEntity entity){
        return new WorkFrequency(entity.getWorkFrequencyId(), entity.getStartWorkFrequency(), entity.getEndWorkFrequency());
    }
}
