package br.juauzitor.smat.application.mapper;

import br.juauzitor.smat.application.dto.TaskCategoryRequest;
import br.juauzitor.smat.application.dto.TaskCategoryResponse;
import br.juauzitor.smat.domain.model.TaskCategory;

public class TaskCategoryMapper {
    public static TaskCategory toDomain(TaskCategoryRequest request){
        return new TaskCategory(null, request.categoryName());
    }

    public static TaskCategoryResponse toResponse(TaskCategory taskCategory){
        return new TaskCategoryResponse(
                taskCategory.getTaskCategoryId(),
                taskCategory.getCategoryName()
        );
    }
}
