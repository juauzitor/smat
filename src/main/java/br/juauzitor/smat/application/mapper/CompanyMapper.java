package br.juauzitor.smat.application.mapper;

import br.juauzitor.smat.domain.model.Company;
import br.juauzitor.smat.application.dto.CompanyRequest;
import br.juauzitor.smat.application.dto.CompanyResponse;

public class CompanyMapper {
    public static Company toDomain(CompanyRequest request){
        return new Company(null, request.companyName());
    }

    public static CompanyResponse toResponse(Company company){
        return new CompanyResponse(
                company.getCompanyId(),
                company.getCompanyName()
        );
    }
}
