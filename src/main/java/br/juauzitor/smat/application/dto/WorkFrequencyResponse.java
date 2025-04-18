package br.juauzitor.smat.application.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record WorkFrequencyResponse(UUID workFrequencyId, LocalDateTime startWorkFrequency, LocalDateTime endWorkFrequency) { }
