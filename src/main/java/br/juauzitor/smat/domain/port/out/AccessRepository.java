package br.juauzitor.smat.domain.port.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccessRepository<T> {
    T saveT(T entity);
    Optional<T> readT(UUID id);
    List<T> readAllT();
    void updateT(T entity);
    void deleteT(UUID id);

}
