package br.juauzitor.smat.application.usecase;

import br.juauzitor.smat.domain.model.TaskCategory;
import br.juauzitor.smat.domain.port.in.TaskCategoryUseCasePort;
import br.juauzitor.smat.domain.port.out.TaskCategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TaskCategoryUseCase implements TaskCategoryUseCasePort {
    private final TaskCategoryRepository repository;

    public TaskCategoryUseCase(TaskCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskCategory createTaskCategory(TaskCategory taskCategory) {
        return repository.saveT(taskCategory);
    }

    @Override
    public Optional<TaskCategory> getTaskCategoryById(UUID id) {
        return repository.readT(id);
    }

    @Override
    public List<TaskCategory> getAllCompanies() {
        return repository.readAllT();
    }

    @Override
    public TaskCategory updateTaskCategory(TaskCategory taskCategory) {
        repository.updateT(taskCategory);
        return taskCategory;
    }

    @Override
    public void deleteTaskCategory(UUID id) {
        repository.deleteT(id);
    }
}
