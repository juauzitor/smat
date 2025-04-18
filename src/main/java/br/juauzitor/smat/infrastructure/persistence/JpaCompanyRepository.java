package br.juauzitor.smat.infrastructure.persistence;

import br.juauzitor.smat.infrastructure.persistence.entities.JpaCompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCompanyRepository extends JpaRepository<JpaCompanyEntity, UUID> {

}
