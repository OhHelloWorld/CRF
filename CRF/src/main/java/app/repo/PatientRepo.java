package app.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.entities.PatientDO;

@Repository
public interface PatientRepo extends CrudRepository<PatientDO, Integer> {

    @Query(value = "select * from patient where id=?1", nativeQuery = true)
    public PatientDO getPatientInformationById(int id);

    @Query(value = "select complete from patient where id=?1", nativeQuery = true)
    public boolean getCompleteById(int id);

    @Query(value = "select * from patient order by ?#{#pageable}", nativeQuery = true)
    public Page<PatientDO> getAll(Pageable pageable);

}
