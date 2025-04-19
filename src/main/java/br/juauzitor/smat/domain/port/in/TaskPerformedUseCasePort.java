package br.juauzitor.smat.domain.port.in;

import br.juauzitor.smat.domain.model.TaskPerformed;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskPerformedUseCasePort {
    TaskPerformed createTaskPerformed(TaskPerformed taskPerformed);
    Optional<TaskPerformed> getTaskPerformedById(UUID id);
    List<TaskPerformed> getAllTaskPerformed();
    TaskPerformed updateTaskPerformed(TaskPerformed taskPerformed);
    void deleteTaskPerformed(UUID id);
}
