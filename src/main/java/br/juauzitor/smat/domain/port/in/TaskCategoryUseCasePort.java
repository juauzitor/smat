package br.juauzitor.smat.domain.port.in;

import br.juauzitor.smat.domain.model.TaskCategory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskCategoryUseCasePort {
    TaskCategory createTaskCategory(TaskCategory taskCategory);
    Optional<TaskCategory> getTaskCategoryById(UUID id);
    List<TaskCategory> getAllCompanies();
    TaskCategory updateTaskCategory(TaskCategory taskCategory);
    void deleteTaskCategory(UUID id);
}
