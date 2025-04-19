package br.juauzitor.smat.application.dto;

import java.util.UUID;

public record TaskPerformedResponse(
        UUID taskPerformedId,
        CompanyResponse company,
        TaskCategoryResponse taskCategory,
        WorkFrequencyResponse workFrequency,
        String description
) {}