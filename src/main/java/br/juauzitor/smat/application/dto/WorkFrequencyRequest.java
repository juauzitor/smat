package br.juauzitor.smat.application.dto;

import java.time.LocalDateTime;

public record WorkFrequencyRequest(LocalDateTime startWorkFrequency, LocalDateTime endWorkFrequency) { }
