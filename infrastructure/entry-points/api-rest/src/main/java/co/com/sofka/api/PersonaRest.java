package co.com.sofka.api;
import co.com.sofka.model.persona.Persona;
import co.com.sofka.usecase.persona.PersonaUseCase;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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


}
