package br.juauzitor.smat.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class WorkFrequency {
    private UUID workFrequencyId;
    private LocalDateTime startWorkFrequency;
    private LocalDateTime endWorkFrequency;

    public WorkFrequency() {
    }

    public WorkFrequency(UUID workFrequencyId, LocalDateTime startWorkFrequency, LocalDateTime endWorkFrequency) {
        this.workFrequencyId = workFrequencyId;
        this.startWorkFrequency = startWorkFrequency;
        this.endWorkFrequency = endWorkFrequency;
    }

    public UUID getWorkFrequencyId() {
        return workFrequencyId;
    }

    public void setWorkFrequencyId(UUID workFrequencyId) {
        this.workFrequencyId = workFrequencyId;
    }

    public LocalDateTime getStartWorkFrequency() {
        return startWorkFrequency;
    }

    public void setStartWorkFrequency(LocalDateTime startWorkFrequency) {
        this.startWorkFrequency = startWorkFrequency;
    }

    public LocalDateTime getEndWorkFrequency() {
        return endWorkFrequency;
    }

    public void setEndWorkFrequency(LocalDateTime endWorkFrequency) {
        this.endWorkFrequency = endWorkFrequency;
    }
}
