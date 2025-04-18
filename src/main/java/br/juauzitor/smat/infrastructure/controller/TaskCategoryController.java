package br.juauzitor.smat.infrastructure.controller;

import br.juauzitor.smat.application.dto.TaskCategoryRequest;
import br.juauzitor.smat.application.dto.TaskCategoryResponse;
import br.juauzitor.smat.application.mapper.TaskCategoryMapper;
import br.juauzitor.smat.domain.model.TaskCategory;
import br.juauzitor.smat.domain.port.in.TaskCategoryUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks_categories")
public class TaskCategoryController {
    private final TaskCategoryUseCasePort taskCategoryUseCase;

    public TaskCategoryController(TaskCategoryUseCasePort taskCategoryUseCase) {
        this.taskCategoryUseCase = taskCategoryUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskCategoryResponse createTaskCategory(@RequestBody TaskCategoryRequest request){
        TaskCategory taskCategory = TaskCategoryMapper.toDomain(request);
        TaskCategory savedTaskCategory = taskCategoryUseCase.createTaskCategory(taskCategory);
        return TaskCategoryMapper.toResponse(savedTaskCategory);
    }
    @GetMapping("/{id}")
    public TaskCategoryResponse getTaskCategoryById(@PathVariable UUID id) {
        Optional<TaskCategory> taskCategory = taskCategoryUseCase.getTaskCategoryById(id);
        return taskCategory.map(TaskCategoryMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("TaskCategory not found"));
    }

    @GetMapping
    public List<TaskCategoryResponse> getAllCompanies() {
        List<TaskCategory> companies = taskCategoryUseCase.getAllCompanies();
        return companies.stream()
                .map(TaskCategoryMapper::toResponse)
                .toList();
    }

    @PutMapping("/{id}")
    public TaskCategoryResponse updateTaskCategory(@PathVariable UUID id, @RequestBody TaskCategoryRequest request) {
        TaskCategory taskCategory = TaskCategoryMapper.toDomain(request);
        taskCategory.setTaskCategoryId(id); // Garante que o ID seja o mesmo do path
        TaskCategory updatedTaskCategory = taskCategoryUseCase.updateTaskCategory(taskCategory);
        return TaskCategoryMapper.toResponse(updatedTaskCategory);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTaskCategory(@PathVariable UUID id) {
        taskCategoryUseCase.deleteTaskCategory(id);
    }
}
