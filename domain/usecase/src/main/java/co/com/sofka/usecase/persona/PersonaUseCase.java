package co.com.sofka.usecase.persona;

import co.com.sofka.model.persona.Persona;
import co.com.sofka.model.persona.gateways.PersonaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class PersonaUseCase {

    private final PersonaRepository personaRepository;

    public Flux< Persona >buscarPersonas(){
        return personaRepository.buscarPersonas();
    }

}

