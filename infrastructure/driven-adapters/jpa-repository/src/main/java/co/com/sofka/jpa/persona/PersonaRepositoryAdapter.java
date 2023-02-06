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
import java.util.Optional;


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
      if (persona != null) {
        PersonaData personaData = Convertidor.convertirPersonaToPersonaData ( persona );
        return Mono.just ( Convertidor.convertirPersonaDataToPersona ( repository.save ( personaData ) ) );
      } else {
        return Mono.empty ( );
      }
    }

    @Override
    public Mono < Persona > buscarPersonaPorId ( Integer id ) {
        Optional < PersonaData > personaData = repository.findById ( id );
        return personaData.map ( personaData1 -> Mono.just ( Convertidor.convertirPersonaDataToPersona ( personaData1 ) ) ).orElseGet ( Mono::empty );
    }


}
