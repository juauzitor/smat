package br.juauzitor.smat.infrastructure.persistence.entities;


import br.juauzitor.smat.domain.model.Company;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Table(name = "Company")
@Entity
public class JpaCompanyEntity {
    @Id
    @GeneratedValue
    private UUID companyId;

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
