package br.juauzitor.smat.domain.model;


import br.juauzitor.smat.domain.port.out.TaskPerformedRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskPerformedTests {

    @Mock
    private TaskPerformedRepository repository; // Mock do repositório

    @Test
    void createAndSaveTaskPerformed() {
        // --- Arrange (Preparação) ---
        UUID taskId = UUID.randomUUID();
        UUID companyId = UUID.randomUUID();
        UUID categoryId = UUID.randomUUID();
        UUID frequencyId = UUID.randomUUID();
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(2);

        // Criação do objeto de domínio
        TaskPerformed task = new TaskPerformed(
                taskId,
                new Company(companyId, "Tech Corp"),
                new TaskCategory(categoryId, "Development"),
                new WorkFrequency(frequencyId, startTime, endTime),
                "Desenvolvimento de nova feature"
        );

        // Configura o mock para retornar o mesmo objeto ao salvar
        when(repository.saveT(any(TaskPerformed.class))).thenReturn(task);

        // --- Act (Execução) ---
        TaskPerformed savedTask = repository.saveT(task);

        // --- Assert (Verificação) ---
        // Verifica se o método save foi chamado 1 vez
        verify(repository, times(1)).saveT(task);

        // Valida os dados retornados
        assertNotNull(savedTask);
        assertEquals(taskId, savedTask.getTaskPerformedId());
        assertEquals("Tech Corp", savedTask.getCompany().getCompanyName());
        assertEquals("Development", savedTask.getTaskCategory().getCategoryName());
        assertEquals(endTime, savedTask.getWorkFrequency().getEndWorkFrequency());
    }
}
