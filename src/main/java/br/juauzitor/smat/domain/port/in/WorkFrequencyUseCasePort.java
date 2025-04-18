package br.juauzitor.smat.domain.port.in;

import br.juauzitor.smat.domain.model.WorkFrequency;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkFrequencyUseCasePort {
    WorkFrequency createWorkFrequency(WorkFrequency workFrequency);
    Optional<WorkFrequency> getWorkFrequencyById(UUID id);
    List<WorkFrequency> getAllCompanies();
    WorkFrequency updateWorkFrequency(WorkFrequency workFrequency);
    void deleteWorkFrequency(UUID id);
}
