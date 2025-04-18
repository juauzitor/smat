package br.juauzitor.smat.infrastructure.persistence;

import br.juauzitor.smat.infrastructure.persistence.entities.JpaTaskCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaTaskCategoryRepository extends JpaRepository<JpaTaskCategoryEntity, UUID> {

}
