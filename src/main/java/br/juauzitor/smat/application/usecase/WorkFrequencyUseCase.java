package br.juauzitor.smat.application.usecase;

import br.juauzitor.smat.domain.model.WorkFrequency;
import br.juauzitor.smat.domain.port.in.WorkFrequencyUseCasePort;
import br.juauzitor.smat.domain.port.out.WorkFrequencyRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class WorkFrequencyUseCase implements WorkFrequencyUseCasePort {
    private final WorkFrequencyRepository repository;

    public WorkFrequencyUseCase(WorkFrequencyRepository repository) {
        this.repository = repository;
    }

    @Override
    public WorkFrequency createWorkFrequency(WorkFrequency workFrequency) {
        return repository.saveT(workFrequency);
    }

    @Override
    public Optional<WorkFrequency> getWorkFrequencyById(UUID id) {
        return repository.readT(id);
    }

    @Override
    public List<WorkFrequency> getAllCompanies() {
        return repository.readAllT();
    }

    @Override
    public WorkFrequency updateWorkFrequency(WorkFrequency workFrequency) {
        repository.updateT(workFrequency);
        return workFrequency;
    }

    @Override
    public void deleteWorkFrequency(UUID id) {
        repository.deleteT(id);
    }
}
