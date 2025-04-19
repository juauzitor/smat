package br.juauzitor.smat.domain.port.out;

import br.juauzitor.smat.domain.model.TaskPerformed;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskPerformedRepository extends AccessRepository<TaskPerformed>{
    @Override
    TaskPerformed saveT(TaskPerformed taskPerformed);

    @Override
    Optional<TaskPerformed> readT(UUID id);

    @Override
    List<TaskPerformed> readAllT();

    @Override
    void updateT(TaskPerformed taskPerformed);

    @Override
    void deleteT(UUID id);
}
