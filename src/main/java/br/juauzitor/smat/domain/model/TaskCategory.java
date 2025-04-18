package br.juauzitor.smat.domain.model;

import java.util.UUID;

public class TaskCategory {
    private UUID taskCategoryId;
    private String categoryName;

    public TaskCategory() {
    }

    public TaskCategory(UUID taskCategoryId, String categoryName) {
        this.taskCategoryId = taskCategoryId;
        this.categoryName = categoryName;
    }

    public UUID getTaskCategoryId() {
        return taskCategoryId;
    }

    public void setTaskCategoryId(UUID taskCategoryId) {
        this.taskCategoryId = taskCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
