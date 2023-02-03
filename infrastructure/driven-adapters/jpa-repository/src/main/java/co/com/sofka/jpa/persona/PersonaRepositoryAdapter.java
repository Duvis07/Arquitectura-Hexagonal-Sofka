package co.com.sofka.jpa.persona;

import co.com.sofka.jpa.convertidor.Convertidor;
import co.com.sofka.jpa.helper.AdapterOperations;
import co.com.sofka.model.persona.Persona;
import co.com.sofka.model.persona.gateways.PersonaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Repository
public class PersonaRepositoryAdapter extends AdapterOperations < Persona, PersonaData, Integer, PersonaDataRepository > implements PersonaRepository {

    public PersonaRepositoryAdapter ( PersonaDataRepository repository , ObjectMapper mapper ) {
        super ( repository , mapper , d -> mapper.mapBuilder ( d , Persona.PersonaBuilder.class ).build ( ) );
    }

    @Override
    public Flux < Persona > buscarPersonas ( ) {
        List < PersonaData > personaDataList = (List < PersonaData >) repository.findAll ( );

        if (!personaDataList.isEmpty ( )) {
            return Flux.fromIterable ( Convertidor.convertirPersonaDataToPersonas ( personaDataList ) );
        } else {
            return Flux.empty ( );
        }

    }

    @Override
    public Mono < Persona > crearPersona ( Persona persona ) {
        return null;
    }

    @Override
    public Mono < Persona > buscarPersonaPorId ( Integer id ) {
        return null;
    }
}
