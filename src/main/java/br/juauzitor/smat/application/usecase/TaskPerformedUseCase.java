package br.juauzitor.smat.application.usecase;

import br.juauzitor.smat.domain.model.TaskPerformed;
import br.juauzitor.smat.domain.port.in.TaskPerformedUseCasePort;
import br.juauzitor.smat.domain.port.out.TaskPerformedRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TaskPerformedUseCase implements TaskPerformedUseCasePort {
    private final TaskPerformedRepository repository;

    public TaskPerformedUseCase(TaskPerformedRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskPerformed createTaskPerformed(TaskPerformed taskPerformed) {
        return repository.saveT(taskPerformed);
    }

    @Override
    public Optional<TaskPerformed> getTaskPerformedById(UUID id) {
        return repository.readT(id);
    }

    @Override
    public List<TaskPerformed> getAllTaskPerformed() {
        return repository.readAllT();
    }

    @Override
    public TaskPerformed updateTaskPerformed(TaskPerformed taskPerformed) {
        repository.updateT(taskPerformed);
        return taskPerformed;
    }

    @Override
    public void deleteTaskPerformed(UUID id) {
        repository.deleteT(id);
    }
}
