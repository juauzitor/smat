package br.juauzitor.smat.domain.model;

import java.util.UUID;

public class TaskPerformed {
    private UUID taskPerformedId;
    private Company company;
    private TaskCategory taskCategory;
    private WorkFrequency workFrequency;
    private String description;

    public TaskPerformed() {
    }

    public TaskPerformed(UUID taskPerformedId, Company company, TaskCategory taskCategory, WorkFrequency workFrequency, String description) {
        this.taskPerformedId = taskPerformedId;
        this.company = company;
        this.taskCategory = taskCategory;
        this.workFrequency = workFrequency;
        this.description = description;
    }

    public UUID getTaskPerformedId() {
        return taskPerformedId;
    }

    public void setTaskPerformedId(UUID taskPerformedId) {
        this.taskPerformedId = taskPerformedId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public TaskCategory getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(TaskCategory taskCategory) {
        this.taskCategory = taskCategory;
    }

    public WorkFrequency getWorkFrequency() {
        return workFrequency;
    }

    public void setWorkFrequency(WorkFrequency workFrequency) {
        this.workFrequency = workFrequency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
