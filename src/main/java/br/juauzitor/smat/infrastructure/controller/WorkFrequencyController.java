package br.juauzitor.smat.infrastructure.controller;

import br.juauzitor.smat.domain.model.WorkFrequency;
import br.juauzitor.smat.domain.port.in.WorkFrequencyUseCasePort;
import br.juauzitor.smat.application.dto.WorkFrequencyRequest;
import br.juauzitor.smat.application.dto.WorkFrequencyResponse;
import br.juauzitor.smat.application.mapper.WorkFrequencyMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/work_frequency")
public class WorkFrequencyController {
    private final WorkFrequencyUseCasePort workFrequencyUseCase;

    public WorkFrequencyController(WorkFrequencyUseCasePort workFrequencyUseCase) {
        this.workFrequencyUseCase = workFrequencyUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkFrequencyResponse createWorkFrequency(@RequestBody WorkFrequencyRequest request){
        WorkFrequency workFrequency = WorkFrequencyMapper.toDomain(request);
        WorkFrequency savedWorkFrequency = workFrequencyUseCase.createWorkFrequency(workFrequency);
        return WorkFrequencyMapper.toResponse(savedWorkFrequency);
    }

    @GetMapping("/{id}")
    public WorkFrequencyResponse getWorkFrequencyById(@PathVariable UUID id) {
        Optional<WorkFrequency> WorkFrequency = workFrequencyUseCase.getWorkFrequencyById(id);
        return WorkFrequency.map(WorkFrequencyMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("WorkFrequency not found"));
    }

    @GetMapping
    public List<WorkFrequencyResponse> getAllCompanies() {
        List<WorkFrequency> companies = workFrequencyUseCase.getAllCompanies();
        return companies.stream()
                .map(WorkFrequencyMapper::toResponse)
                .toList();
    }

    @PutMapping("/{id}")
    public WorkFrequencyResponse updateWorkFrequency(@PathVariable UUID id, @RequestBody WorkFrequencyRequest request) {
        WorkFrequency WorkFrequency = WorkFrequencyMapper.toDomain(request);
        WorkFrequency.setWorkFrequencyId(id); // Garante que o ID seja o mesmo do path
        WorkFrequency updatedWorkFrequency = workFrequencyUseCase.updateWorkFrequency(WorkFrequency);
        return WorkFrequencyMapper.toResponse(updatedWorkFrequency);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWorkFrequency(@PathVariable UUID id) {
        workFrequencyUseCase.deleteWorkFrequency(id);
    }
}

