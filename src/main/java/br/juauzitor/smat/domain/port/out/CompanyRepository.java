package br.juauzitor.smat.domain.port.out;

import br.juauzitor.smat.domain.model.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends AccessRepository<Company>{
    @Override
    Company saveT(Company company);

    @Override
    Optional<Company> readT(UUID id);

    @Override
    List<Company> readAllT();

    @Override
    void updateT(Company company);

    @Override
    void deleteT(UUID id);
}
