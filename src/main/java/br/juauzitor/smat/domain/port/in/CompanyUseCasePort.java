package br.juauzitor.smat.domain.port.in;

import br.juauzitor.smat.domain.model.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyUseCasePort {
    Company createCompany(Company company);
    Optional<Company> getCompanyById(UUID id);
    List<Company> getAllCompanies();
    Company updateCompany(Company company);
    void deleteCompany(UUID id);
}
