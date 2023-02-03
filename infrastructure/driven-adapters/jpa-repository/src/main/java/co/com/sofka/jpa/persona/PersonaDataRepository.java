package co.com.sofka.jpa.persona;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Service;

@Service
public interface PersonaDataRepository extends CrudRepository <PersonaData, Integer>, QueryByExampleExecutor <PersonaData> {

}
