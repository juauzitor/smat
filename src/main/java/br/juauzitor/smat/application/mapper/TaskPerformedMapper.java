package br.juauzitor.smat.application.mapper;

import br.juauzitor.smat.application.dto.TaskCategoryResponse;
import br.juauzitor.smat.application.dto.TaskPerformedRequest;
import br.juauzitor.smat.application.dto.TaskPerformedResponse;
import br.juauzitor.smat.domain.model.Company;
import br.juauzitor.smat.domain.model.TaskCategory;
import br.juauzitor.smat.domain.model.TaskPerformed;
import br.juauzitor.smat.domain.model.WorkFrequency;

public class TaskPerformedMapper {
    public static TaskPerformed toDomain(TaskPerformedRequest request){
        TaskPerformed taskPerformed = new TaskPerformed();
        taskPerformed.setTaskPerformedId(null);
        taskPerformed.setCompany(new Company(request.companyId(),null));
        taskPerformed.setTaskCategory(new TaskCategory(request.taskCategoryId(), null));
        taskPerformed.setWorkFrequency(new WorkFrequency(request.workFrequencyId(), null, null));
        taskPerformed.setDescription(request.description());
        return taskPerformed;
    }

    public static TaskPerformedResponse toResponse(TaskPerformed taskPerformed){
        return new TaskPerformedResponse(
                taskPerformed.getTaskPerformedId(),
                CompanyMapper.toResponse(taskPerformed.getCompany()),
                TaskCategoryMapper.toResponse(taskPerformed.getTaskCategory()),
                WorkFrequencyMapper.toResponse(taskPerformed.getWorkFrequency()),
                taskPerformed.getDescription()
        );
    }
}

