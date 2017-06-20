package app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.InformationInputDO;

public interface InformationInputRepo extends CrudRepository<InformationInputDO, Integer> {

    @Query(value = "select input_modular_id from information_input where information_id=?1",
            nativeQuery = true)
    public List<Integer> getInputId(int informationId);
}
