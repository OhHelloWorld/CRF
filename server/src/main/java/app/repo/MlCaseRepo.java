package app.repo;

import app.entities.MlPatientDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2017/10/13 0013.
 */
public interface MlCaseRepo extends PagingAndSortingRepository<MlPatientDO,Integer> {

    @Query(value = "select * from medicine_liver_patient where name like %?1% order by ?#{#pageable}", nativeQuery = true)
    Page<MlPatientDO> findMlByCaseName(String caseName, Pageable pageable);
}
