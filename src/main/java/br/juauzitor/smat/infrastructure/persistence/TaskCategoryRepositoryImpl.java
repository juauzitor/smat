package br.juauzitor.smat.infrastructure.persistence;

import br.juauzitor.smat.domain.model.TaskCategory;
import br.juauzitor.smat.domain.port.out.TaskCategoryRepository;
import br.juauzitor.smat.infrastructure.persistence.entities.JpaTaskCategoryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class TaskCategoryRepositoryImpl implements TaskCategoryRepository {
    private final JpaTaskCategoryRepository jpaTaskCategoryRepository;

    public TaskCategoryRepositoryImpl(JpaTaskCategoryRepository jpaTaskCategoryRepository) {
        this.jpaTaskCategoryRepository = jpaTaskCategoryRepository;
    }

    @Override
    public TaskCategory saveT(TaskCategory taskCategory) {
        JpaTaskCategoryEntity taskCategoryEntity = new JpaTaskCategoryEntity(taskCategory);
        this.jpaTaskCategoryRepository.save(taskCategoryEntity);
        return new TaskCategory(taskCategoryEntity.getTaskCategoryId(), taskCategoryEntity.getCategoryName());
    }

    @Override
    public Optional<TaskCategory> readT(UUID id) {
        Optional<JpaTaskCategoryEntity> taskCategoryEntity = this.jpaTaskCategoryRepository.findById(id);
        return taskCategoryEntity.map(entity -> new TaskCategory(entity.getTaskCategoryId(), entity.getCategoryName()));
    }

    @Override
    public List<TaskCategory> readAllT() {
        return jpaTaskCategoryRepository.findAll()
        .stream()
        .map(entity -> new TaskCategory(entity.getTaskCategoryId(), entity.getCategoryName()))
        .collect(Collectors.toList());
    }

    @Override
    public void updateT(TaskCategory taskCategory) {
        if (this.jpaTaskCategoryRepository.existsById(taskCategory.getTaskCategoryId())){
            JpaTaskCategoryEntity taskCategoryEntity = new JpaTaskCategoryEntity(taskCategory);
        } else {
            throw new RuntimeException("TaskCategory not found with id: " + taskCategory.getTaskCategoryId().toString());
        }
    }

    @Override
    public void deleteT(UUID id) {
        this.jpaTaskCategoryRepository.deleteById(id);
    }
}