package br.juauzitor.smat.infrastructure.persistence.entities;

import br.juauzitor.smat.domain.model.TaskCategory;
import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "TaskCategory")
@Entity
public class JpaTaskCategoryEntity {
    @Id
    @GeneratedValue
    @Column(name = "task_category_id", columnDefinition = "UUID")
    private UUID taskCategoryId;

    @Column(name = "category_name")
    private String categoryName;

    public JpaTaskCategoryEntity() {
    }

    public JpaTaskCategoryEntity(UUID taskCategoryId, String categoryName) {
        this.taskCategoryId = taskCategoryId;
        this.categoryName = categoryName;
    }

    public JpaTaskCategoryEntity(TaskCategory taskCategory) {
        this.taskCategoryId = taskCategory.getTaskCategoryId();
        this.categoryName = taskCategory.getCategoryName();
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
