package br.juauzitor.smat.infrastructure.persistence;

import br.juauzitor.smat.application.dto.TaskPerformedRequest;
import br.juauzitor.smat.application.dto.TaskPerformedResponse;
import br.juauzitor.smat.application.mapper.TaskPerformedMapper;
import br.juauzitor.smat.domain.model.Company;
import br.juauzitor.smat.domain.model.TaskCategory;
import br.juauzitor.smat.domain.model.TaskPerformed;
import br.juauzitor.smat.domain.model.WorkFrequency;
import br.juauzitor.smat.application.usecase.TaskPerformedUseCase;
import br.juauzitor.smat.infrastructure.controller.TaskPerformedController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskPerformedController.class)
public class TaskPerformedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TaskPerformedUseCase taskPerformedUseCase;

    // Método auxiliar para criar uma TaskPerformed de teste
    private TaskPerformed createTestTask(UUID taskId, UUID companyId, UUID taskCategoryId, UUID workFrequencyId) {
        TaskPerformed task = new TaskPerformed();
        task.setTaskPerformedId(taskId);
        task.setCompany(new Company(companyId, null)); // Apenas ID
        task.setTaskCategory(new TaskCategory(taskCategoryId, null)); // Apenas ID
        task.setWorkFrequency(new WorkFrequency(workFrequencyId, null, null)); // Apenas ID
        task.setDescription("Test Description");
        return task;
    }

    // ----------- TESTE POST -----------
    @Test
    void createTaskPerformed_ShouldReturnCreatedTask() throws Exception {
        UUID taskId = UUID.randomUUID();
        UUID companyId = UUID.randomUUID();
        UUID taskCategoryId = UUID.randomUUID();
        UUID workFrequencyId = UUID.randomUUID();

        TaskPerformedRequest request = new TaskPerformedRequest(
                companyId,
                taskCategoryId,
                workFrequencyId,
                "Test Description"
        );

        TaskPerformed createdTask = createTestTask(taskId, companyId, taskCategoryId, workFrequencyId);

        Mockito.when(taskPerformedUseCase.createTaskPerformed(Mockito.any()))
                .thenReturn(createdTask);

        mockMvc.perform(post("/api/task_performed")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.taskPerformedId", is(taskId.toString())))
                .andExpect(jsonPath("$.company.companyId", is(companyId.toString()))) // Verifica apenas o ID
                .andExpect(jsonPath("$.taskCategory.taskCategoryId", is(taskCategoryId.toString())))
                .andExpect(jsonPath("$.workFrequency.workFrequencyId", is(workFrequencyId.toString())));
    }

    // ----------- TESTE GET por ID -----------
    @Test
    void getTaskPerformedById_WhenExists_ShouldReturnTask() throws Exception {
        UUID taskId = UUID.randomUUID();
        UUID companyId = UUID.randomUUID();
        TaskPerformed task = createTestTask(taskId, companyId, UUID.randomUUID(), UUID.randomUUID());

        Mockito.when(taskPerformedUseCase.getTaskPerformedById(taskId))
                .thenReturn(Optional.of(task));

        mockMvc.perform(get("/api/task_performed/" + taskId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.taskPerformedId", is(taskId.toString())))
                .andExpect(jsonPath("$.description", is("Test Description")));
    }

    // ----------- TESTE GET All -----------
    @Test
    void getAllTasksPerformed_ShouldReturnList() throws Exception {
        TaskPerformed task1 = createTestTask(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID());
        TaskPerformed task2 = createTestTask(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID());

        Mockito.when(taskPerformedUseCase.getAllTaskPerformed())
                .thenReturn(List.of(task1, task2));

        mockMvc.perform(get("/api/task_performed"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].taskPerformedId", is(task1.getTaskPerformedId().toString())))
                .andExpect(jsonPath("$[1].company.companyId", is(task2.getCompany().getCompanyId().toString())));
    }

    // ----------- TESTE PUT -----------
    @Test
    void updateTaskPerformed_ShouldReturnUpdatedTask() throws Exception {
        UUID taskId = UUID.randomUUID();
        UUID newCompanyId = UUID.randomUUID();
        UUID newTaskCategoryId = UUID.randomUUID();
        UUID newWorkFrequencyId = UUID.randomUUID();

        TaskPerformedRequest request = new TaskPerformedRequest(
                newCompanyId,
                newTaskCategoryId,
                newWorkFrequencyId,
                "Updated Description"
        );

        TaskPerformed updatedTask = createTestTask(taskId, newCompanyId, newTaskCategoryId, newWorkFrequencyId);
        updatedTask.setDescription("Updated Description");

        Mockito.when(taskPerformedUseCase.updateTaskPerformed(Mockito.any()))
                .thenReturn(updatedTask);

        mockMvc.perform(put("/api/task_performed/" + taskId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", is("Updated Description")))
                .andExpect(jsonPath("$.taskCategory.taskCategoryId", is(newTaskCategoryId.toString())));
    }


    // ----------- TESTE DELETE -----------
    @Test
    void deleteTaskPerformed_ShouldReturnNoContent() throws Exception {
        UUID taskId = UUID.randomUUID();
        mockMvc.perform(delete("/api/task_performed/" + taskId))
                .andExpect(status().isNoContent());

        Mockito.verify(taskPerformedUseCase, Mockito.times(1))
                .deleteTaskPerformed(taskId);
    }
}