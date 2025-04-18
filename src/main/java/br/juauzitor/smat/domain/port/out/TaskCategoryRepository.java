package br.juauzitor.smat.domain.port.out;

import br.juauzitor.smat.domain.model.TaskCategory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskCategoryRepository extends AccessRepository<TaskCategory> {
    @Override
    TaskCategory saveT(TaskCategory taskCategory);

    @Override
    Optional<TaskCategory> readT(UUID id);

    @Override
    List<TaskCategory> readAllT();

    @Override
    void updateT(TaskCategory taskCategory);

    @Override
    void deleteT(UUID id);
}
