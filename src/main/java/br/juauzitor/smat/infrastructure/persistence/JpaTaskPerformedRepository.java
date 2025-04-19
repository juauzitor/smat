package br.juauzitor.smat.infrastructure.persistence;

import br.juauzitor.smat.infrastructure.persistence.entities.JpaTaskPerformedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaTaskPerformedRepository extends JpaRepository<JpaTaskPerformedEntity, UUID> {
}
