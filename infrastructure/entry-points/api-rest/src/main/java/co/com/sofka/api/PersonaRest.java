package co.com.sofka.api;
import co.com.sofka.model.persona.Persona;
import co.com.sofka.usecase.persona.PersonaUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class PersonaRest {
 private final PersonaUseCase personaUseCase;

    @GetMapping(value = "/personas")
  public Flux< Persona > buscarPersonasParaViajar(){
        return personaUseCase.buscarPersonas();
    }


    @GetMapping(value = "/personas/{id}")
    public Mono< Persona > buscarPersonaPorId(@PathVariable("id") Integer id){
        return personaUseCase.buscarPersonaPorId(id);
    }


    @PostMapping(value = "/personas")
    public Mono< Persona > crearPersona(@RequestBody Persona persona){
        return personaUseCase.guardarPersona(persona);
    }


    @GetMapping(value = "/buscar-por-comando")
    public Mono<String> buscarPersonaPorComando(){
        return personaUseCase.buscarPersonaPorComando();
    }


}
