package br.juauzitor.smat.application.dto;

import java.util.UUID;

public record TaskPerformedRequest(
        UUID companyId,
        UUID taskCategoryId,
        UUID workFrequencyId,
        String description
) {}