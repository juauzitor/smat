package br.juauzitor.smat.infrastructure.persistence.entities;


import br.juauzitor.smat.domain.model.Company;
import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "Company")
@Entity
public class JpaCompanyEntity {
    @Id
    @GeneratedValue
    @Column(name = "company_id", columnDefinition = "UUID")
    private UUID companyId;

    @Column(name = "company_name")
    private String companyName;

    public JpaCompanyEntity() {
    }

    public JpaCompanyEntity(UUID companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public JpaCompanyEntity(Company company) {
        this.companyId = company.getCompanyId();
        this.companyName = company.getCompanyName();
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
