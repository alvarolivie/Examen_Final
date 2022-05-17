package edu.icai.pat.repository;

import edu.icai.pat.model.Dispositivo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoRepo extends CrudRepository<Dispositivo, Long> {
}
