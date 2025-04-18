package br.juauzitor.smat.application.mapper;

import br.juauzitor.smat.domain.model.WorkFrequency;
import br.juauzitor.smat.application.dto.WorkFrequencyRequest;
import br.juauzitor.smat.application.dto.WorkFrequencyResponse;

public class WorkFrequencyMapper {
    public static WorkFrequency toDomain(WorkFrequencyRequest request) {
        return new WorkFrequency(null, request.startWorkFrequency(), request.endWorkFrequency());
    }

    public static WorkFrequencyResponse toResponse(WorkFrequency workFrequency){
        return new WorkFrequencyResponse(
                workFrequency.getWorkFrequencyId(),
                workFrequency.getStartWorkFrequency(),
                workFrequency.getEndWorkFrequency()
        );
    }
}