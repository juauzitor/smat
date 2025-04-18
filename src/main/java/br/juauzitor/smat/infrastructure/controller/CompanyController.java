package br.juauzitor.smat.infrastructure.controller;

import br.juauzitor.smat.domain.model.Company;
import br.juauzitor.smat.domain.port.in.CompanyUseCasePort;
import br.juauzitor.smat.application.dto.CompanyRequest;
import br.juauzitor.smat.application.dto.CompanyResponse;
import br.juauzitor.smat.application.mapper.CompanyMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyUseCasePort companyUseCase;

    public CompanyController(CompanyUseCasePort companyUseCase) {
        this.companyUseCase = companyUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyResponse createCompany(@RequestBody CompanyRequest request){
        Company company = CompanyMapper.toDomain(request);
        Company savedCompany = companyUseCase.createCompany(company);
        return CompanyMapper.toResponse(savedCompany);
    }
    @GetMapping("/{id}")
    public CompanyResponse getCompanyById(@PathVariable UUID id) {
        Optional<Company> company = companyUseCase.getCompanyById(id);
        return company.map(CompanyMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Company not found"));
    }

    @GetMapping
    public List<CompanyResponse> getAllCompanies() {
        List<Company> companies = companyUseCase.getAllCompanies();
        return companies.stream()
                .map(CompanyMapper::toResponse)
                .toList();
    }

    @PutMapping("/{id}")
    public CompanyResponse updateCompany(@PathVariable UUID id, @RequestBody CompanyRequest request) {
        Company company = CompanyMapper.toDomain(request);
        company.setCompanyId(id); // Garante que o ID seja o mesmo do path
        Company updatedCompany = companyUseCase.updateCompany(company);
        return CompanyMapper.toResponse(updatedCompany);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable UUID id) {
        companyUseCase.deleteCompany(id);
    }
}
