package br.juauzitor.smat.infrastructure.persistence;

import br.juauzitor.smat.application.dto.CompanyRequest;
import br.juauzitor.smat.application.dto.CompanyResponse;
import br.juauzitor.smat.application.mapper.CompanyMapper;
import br.juauzitor.smat.domain.model.Company;
import br.juauzitor.smat.domain.port.in.CompanyUseCasePort;
import br.juauzitor.smat.infrastructure.controller.CompanyController;
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

@WebMvcTest(CompanyController.class)
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CompanyUseCasePort companyUseCase;

    // Teste POST
    @Test
    void createCompany_ShouldReturnCreatedCompany() throws Exception {
        CompanyRequest request = new CompanyRequest("Tech Corp");
        Company company = CompanyMapper.toDomain(request);
        company.setCompanyId(UUID.randomUUID());
        CompanyResponse response = CompanyMapper.toResponse(company);

        Mockito.when(companyUseCase.createCompany(Mockito.any(Company.class))).thenReturn(company);

        mockMvc.perform(post("/api/companies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.companyId", is(company.getCompanyId().toString())))
                .andExpect(jsonPath("$.companyName", is(request.companyName()))); // Campo alterado
    }

    // Teste GET por ID
    @Test
    void getCompanyById_WhenExists_ShouldReturnCompany() throws Exception {
        UUID id = UUID.randomUUID();
        Company company = new Company(id, "Tech Corp"); // Construtor atualizado
        CompanyResponse response = CompanyMapper.toResponse(company);

        Mockito.when(companyUseCase.getCompanyById(id)).thenReturn(Optional.of(company));

        mockMvc.perform(get("/api/companies/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.companyId", is(id.toString())))
                .andExpect(jsonPath("$.companyName", is(company.getCompanyName()))); // Getter alterado
    }

    // Teste GET All
    @Test
    void getAllCompanies_ShouldReturnList() throws Exception {
        Company company1 = new Company(UUID.randomUUID(), "Tech Corp");
        Company company2 = new Company(UUID.randomUUID(), "Dev Inc");
        List<Company> companies = List.of(company1, company2);

        Mockito.when(companyUseCase.getAllCompanies()).thenReturn(companies);

        mockMvc.perform(get("/api/companies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].companyName", is(company1.getCompanyName()))) // Campo alterado
                .andExpect(jsonPath("$[1].companyName", is(company2.getCompanyName())));
    }

    // Teste PUT
    @Test
    void updateCompany_ShouldReturnUpdatedCompany() throws Exception {
        UUID id = UUID.randomUUID();
        CompanyRequest request = new CompanyRequest("Updated Corp");
        Company company = CompanyMapper.toDomain(request);
        company.setCompanyId(id);

        Mockito.when(companyUseCase.updateCompany(Mockito.any(Company.class))).thenReturn(company);

        mockMvc.perform(put("/api/companies/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.companyName", is(request.companyName()))); // Campo alterado
    }

    // Teste para DELETE /api/companies/{id}
    @Test
    void deleteCompany_ShouldReturnNoContent() throws Exception {
        UUID id = UUID.randomUUID();
        mockMvc.perform(delete("/api/companies/" + id))
                .andExpect(status().isNoContent());

        Mockito.verify(companyUseCase, Mockito.times(1)).deleteCompany(id);
    }
}