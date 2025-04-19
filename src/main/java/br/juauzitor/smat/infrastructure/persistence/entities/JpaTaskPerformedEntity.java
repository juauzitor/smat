package br.juauzitor.smat.infrastructure.persistence.entities;

import br.juauzitor.smat.domain.model.TaskPerformed;
import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "TaskPerformed")
@Entity
public class JpaTaskPerformedEntity {
    @Id
    @GeneratedValue
    @Column(name = "task_performed_id", columnDefinition = "UUID")
    private UUID taskPerformedId;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private JpaCompanyEntity company;

    @ManyToOne
    @JoinColumn(name = "task_category_id", referencedColumnName = "task_category_id")
    private JpaTaskCategoryEntity taskCategory;

    @ManyToOne
    @JoinColumn(name = "work_frequency_id", referencedColumnName = "work_frequency_id")
    private JpaWorkFrequencyEntity workFrequency;

    @Column(name = "description", length = 1024)
    private String description;

    public JpaTaskPerformedEntity() {
    }

    public JpaTaskPerformedEntity(UUID taskPerformedId, JpaCompanyEntity company, JpaTaskCategoryEntity taskCategory, JpaWorkFrequencyEntity workFrequency, String description) {
        this.taskPerformedId = taskPerformedId;
        this.company = company;
        this.taskCategory = taskCategory;
        this.workFrequency = workFrequency;
        this.description = description;
    }

    public JpaTaskPerformedEntity(TaskPerformed taskPerformed) {
        this.taskPerformedId = taskPerformed.getTaskPerformedId();
        this.company = new JpaCompanyEntity(taskPerformed.getCompany());
        this.taskCategory = new JpaTaskCategoryEntity(taskPerformed.getTaskCategory());
        this.workFrequency = new JpaWorkFrequencyEntity(taskPerformed.getWorkFrequency());
        this.description = taskPerformed.getDescription();
    }

    public UUID getTaskPerformedId() {
        return taskPerformedId;
    }

    public void setTaskPerformedId(UUID taskPerformedId) {
        this.taskPerformedId = taskPerformedId;
    }

    public JpaCompanyEntity getCompany() {
        return company;
    }

    public void setCompany(JpaCompanyEntity company) {
        this.company = company;
    }

    public JpaTaskCategoryEntity getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(JpaTaskCategoryEntity taskCategory) {
        this.taskCategory = taskCategory;
    }

    public JpaWorkFrequencyEntity getWorkFrequency() {
        return workFrequency;
    }

    public void setWorkFrequency(JpaWorkFrequencyEntity workFrequency) {
        this.workFrequency = workFrequency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
