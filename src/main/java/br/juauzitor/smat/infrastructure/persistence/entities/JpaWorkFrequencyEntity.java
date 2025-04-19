package br.juauzitor.smat.infrastructure.persistence.entities;

import br.juauzitor.smat.domain.model.WorkFrequency;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "WorkFrequency")
@Entity
public class JpaWorkFrequencyEntity {

    @Id
    @GeneratedValue
    @Column(name = "work_frequency_id")
    private UUID workFrequencyId;

    @Column(name = "start_Work_Frequency")
    private LocalDateTime startWorkFrequency;

    @Column(name = "end_Work_Frequency")
    private LocalDateTime endWorkFrequency;

    public JpaWorkFrequencyEntity() {
    }

    public JpaWorkFrequencyEntity(UUID workFrequencyId, LocalDateTime startWorkFrequency, LocalDateTime endWorkFrequency) {
        this.workFrequencyId = workFrequencyId;
        this.startWorkFrequency = startWorkFrequency;
        this.endWorkFrequency = endWorkFrequency;
    }

    public JpaWorkFrequencyEntity(WorkFrequency workFrequency) {
        this.workFrequencyId = workFrequency.getWorkFrequencyId();
        this.startWorkFrequency = workFrequency.getStartWorkFrequency();
        this.endWorkFrequency = workFrequency.getEndWorkFrequency();
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
