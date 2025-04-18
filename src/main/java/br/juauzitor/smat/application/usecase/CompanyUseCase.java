package br.juauzitor.smat.application.usecase;

import br.juauzitor.smat.domain.model.Company;
import br.juauzitor.smat.domain.port.in.CompanyUseCasePort;
import br.juauzitor.smat.domain.port.out.CompanyRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CompanyUseCase implements CompanyUseCasePort {
    private final CompanyRepository repository;

    public CompanyUseCase(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Company createCompany(Company company) {
        return repository.saveT(company);
    }

    @Override
    public Optional<Company> getCompanyById(UUID id) {
        return repository.readT(id);
    }

    @Override
    public List<Company> getAllCompanies() {
        return repository.readAllT();
    }

    @Override
    public Company updateCompany(Company company) {
        repository.updateT(company);
        return company;
    }

    @Override
    public void deleteCompany(UUID id) {
        repository.deleteT(id);
    }
}
