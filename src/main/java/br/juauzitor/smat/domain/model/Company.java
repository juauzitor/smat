package br.juauzitor.smat.domain.model;

import java.util.UUID;

public class Company {
    private UUID companyId;
    private String companyName;

    public Company() {
    }

    public Company(UUID companyId, String compania) {
        this.companyId = companyId;
        this.companyName = compania;
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
