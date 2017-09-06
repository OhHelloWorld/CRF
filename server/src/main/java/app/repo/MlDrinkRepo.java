//package app.repo;
//
//import app.entities.MedicineLiverDrinkDO;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
///**
// * Created by Administrator on 2017/9/5 0005.
// */
//public interface MlDrinkRepo extends CrudRepository<MedicineLiverDrinkDO,Integer> {
//
//    @Query(value = "select * from medicine_liver_drink where patient_id=?1 order by id desc limit 1",nativeQuery = true)
//    MedicineLiverDrinkDO getMlDrinkByPatientId(int mlPatientId);
//}
