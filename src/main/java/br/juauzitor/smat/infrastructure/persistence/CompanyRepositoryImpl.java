package br.juauzitor.smat.infrastructure.persistence;

import br.juauzitor.smat.infrastructure.persistence.entities.JpaCompanyEntity;
import br.juauzitor.smat.domain.model.Company;
import br.juauzitor.smat.domain.port.out.CompanyRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {
    public final JpaCompanyRepository jpaCompanyRepository;

    public CompanyRepositoryImpl(JpaCompanyRepository jpaCompanyRepository) {
        this.jpaCompanyRepository = jpaCompanyRepository;
    }

    @Override
    public Company saveT(Company company) {
        JpaCompanyEntity companyEntity = new JpaCompanyEntity(company);
        this.jpaCompanyRepository.save(companyEntity);
        return new Company(companyEntity.getCompanyId(), companyEntity.getCompanyName());
    }

    @Override
    public Optional<Company> readT(UUID id) {
        Optional<JpaCompanyEntity> companyEntity = this.jpaCompanyRepository.findById(id);
        return companyEntity.map(entity -> new Company(entity.getCompanyId(), entity.getCompanyName()));
    }

    @Override
    public List<Company> readAllT() {
        return  this.jpaCompanyRepository.findAll()
        .stream()
        .map(entity -> new Company(entity.getCompanyId(), entity.getCompanyName()))
        .collect(Collectors.toList());
    }

    @Override
    public void updateT(Company company) {
        if (this.jpaCompanyRepository.existsById(company.getCompanyId())){
            JpaCompanyEntity companyEntity = new JpaCompanyEntity(company);
            this.jpaCompanyRepository.save(companyEntity);
        } else {
            throw new RuntimeException("Company not found with id: " + company.getCompanyId().toString());
        }
    }

    @Override
    public void deleteT(UUID id) {
        this.jpaCompanyRepository.deleteById(id);
    }
}
