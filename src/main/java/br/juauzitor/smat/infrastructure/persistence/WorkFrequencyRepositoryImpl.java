package br.juauzitor.smat.infrastructure.persistence;

import br.juauzitor.smat.domain.model.WorkFrequency;
import br.juauzitor.smat.domain.port.out.WorkFrequencyRepository;
import br.juauzitor.smat.infrastructure.persistence.entities.JpaWorkFrequencyEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class WorkFrequencyRepositoryImpl implements WorkFrequencyRepository {
    private final JpaWorkFrequencyRepository jpaWorkFrequencyRepository;

    public WorkFrequencyRepositoryImpl(JpaWorkFrequencyRepository jpaWorkFrequencyRepository) {
        this.jpaWorkFrequencyRepository = jpaWorkFrequencyRepository;
    }

    @Override
    public WorkFrequency saveT(WorkFrequency workFrequency) {
        JpaWorkFrequencyEntity workFrequencyEntity = new JpaWorkFrequencyEntity(workFrequency);
        this.jpaWorkFrequencyRepository.save(workFrequencyEntity);
        return new WorkFrequency(workFrequencyEntity.getWorkFrequencyId(), workFrequencyEntity.getStartWorkFrequency(), workFrequencyEntity.getEndWorkFrequency());
    }

    @Override
    public Optional<WorkFrequency> readT(UUID id) {
        Optional<JpaWorkFrequencyEntity> workFrequencyEntity = this.jpaWorkFrequencyRepository.findById(id);
        return workFrequencyEntity.map(entity -> new WorkFrequency(entity.getWorkFrequencyId(), entity.getStartWorkFrequency(), entity.getEndWorkFrequency()));
    }

    @Override
    public List<WorkFrequency> readAllT() {
        return this.jpaWorkFrequencyRepository.findAll()
        .stream()
        .map(entity -> new WorkFrequency(entity.getWorkFrequencyId(), entity.getStartWorkFrequency(), entity.getEndWorkFrequency()))
        .collect(Collectors.toList());
    }

    @Override
    public void updateT(WorkFrequency workFrequency) {
        if (this.jpaWorkFrequencyRepository.existsById(workFrequency.getWorkFrequencyId())){
            JpaWorkFrequencyEntity workFrequencyEntity = new JpaWorkFrequencyEntity(workFrequency);
            this.jpaWorkFrequencyRepository.save(workFrequencyEntity);
        } else {
            throw new RuntimeException("WorkFrequency not found with id: " + workFrequency.getWorkFrequencyId().toString());
        }
    }

    @Override
    public void deleteT(UUID id) {
        this.jpaWorkFrequencyRepository.deleteById(id);
    }
}
