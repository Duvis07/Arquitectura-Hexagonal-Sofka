package co.com.sofka.publisher;

import co.com.sofka.model.persona.gateways.PersonaPublicador;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.async.api.DirectAsyncGateway;
import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@EnableDirectAsyncGateway
@RequiredArgsConstructor
public class PublicadorRabbitmq implements PersonaPublicador {

    private final DirectAsyncGateway disparadorComando;

    static final String PERSONAS_VIAJERAS = "personas.viajeras";

    @Override
    public Mono<String> publicarPersonasViajeras() {
        final Command<String> comando = new Command<>(
                PERSONAS_VIAJERAS,
                UUID.randomUUID().toString(),
                "Hello World");
        return disparadorComando.sendCommand(
                comando, "arquitectura-hexagonal")
                        .thenReturn("Mensaje enviado de forma exitosa");
    }
}
