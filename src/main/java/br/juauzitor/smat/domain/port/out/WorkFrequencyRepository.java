package br.juauzitor.smat.domain.port.out;

import br.juauzitor.smat.domain.model.WorkFrequency;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkFrequencyRepository extends AccessRepository<WorkFrequency>{
    @Override
    WorkFrequency saveT(WorkFrequency workFrequency);

    @Override
    Optional<WorkFrequency> readT(UUID id);

    @Override
    List<WorkFrequency> readAllT();

    @Override
    void updateT(WorkFrequency workFrequency);

    @Override
    void deleteT(UUID id);
}
