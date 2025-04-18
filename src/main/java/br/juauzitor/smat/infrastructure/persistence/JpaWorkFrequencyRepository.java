package br.juauzitor.smat.infrastructure.persistence;

import br.juauzitor.smat.infrastructure.persistence.entities.JpaWorkFrequencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaWorkFrequencyRepository extends JpaRepository<JpaWorkFrequencyEntity, UUID> {

}
