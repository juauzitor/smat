package br.juauzitor.smat.infrastructure.controller;


import br.juauzitor.smat.application.dto.TaskPerformedRequest;
import br.juauzitor.smat.application.dto.TaskPerformedResponse;
import br.juauzitor.smat.application.mapper.TaskPerformedMapper;
import br.juauzitor.smat.domain.model.TaskPerformed;
import br.juauzitor.smat.domain.port.in.TaskPerformedUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/task_performed")
public class TaskPerformedController {
    private final TaskPerformedUseCasePort taskPerformedUseCase;

    public TaskPerformedController(TaskPerformedUseCasePort taskPerformedUseCase) {
        this.taskPerformedUseCase = taskPerformedUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskPerformedResponse createTaskPerformed(@RequestBody TaskPerformedRequest request) {
        TaskPerformed taskPerformed = TaskPerformedMapper.toDomain(request);
        TaskPerformed savedTaskPerformed = taskPerformedUseCase.createTaskPerformed(taskPerformed);
        return TaskPerformedMapper.toResponse(savedTaskPerformed);
    }

    @GetMapping("/{id}")
    public TaskPerformedResponse getTaskPerformedById(@PathVariable UUID id){
        Optional<TaskPerformed> taskPerformed = taskPerformedUseCase.getTaskPerformedById(id);
        return taskPerformed.map(TaskPerformedMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Task Performed not found"));
    }

    @GetMapping
    public List<TaskPerformedResponse> getAllTaskPerformed(){
        List<TaskPerformed> taskPerformeds = taskPerformedUseCase.getAllTaskPerformed();
        return taskPerformeds.stream()
                .map(TaskPerformedMapper::toResponse)
                .toList();
    }

    @PutMapping("/{id}")
    public TaskPerformedResponse updateTaskPerformed(@PathVariable UUID id, @RequestBody TaskPerformedRequest request){
        TaskPerformed taskPerformed = TaskPerformedMapper.toDomain(request);
        taskPerformed.setTaskPerformedId(id);
        TaskPerformed updatedTaskPerformed = taskPerformedUseCase.updateTaskPerformed(taskPerformed);
        return TaskPerformedMapper.toResponse(updatedTaskPerformed);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTaskPerformed(@PathVariable UUID id){
        taskPerformedUseCase.deleteTaskPerformed(id);
    }
}