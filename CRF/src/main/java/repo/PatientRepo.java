package repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entities.PatientDO;

@Repository
public interface PatientRepo extends CrudRepository<PatientDO, Integer> {

}
