package app.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.InputModularDO;

public interface InputModularRepo extends CrudRepository<InputModularDO, Integer> {

    @Query(value = "select * from input_modular where id=?1", nativeQuery = true)
    public InputModularDO getInputModularById(int id);
}
