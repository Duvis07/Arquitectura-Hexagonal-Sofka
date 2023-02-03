package co.com.sofka.jpa.convertidor;

import co.com.sofka.jpa.persona.PersonaData;
import co.com.sofka.jpa.viaje.ViajeData;
import co.com.sofka.model.persona.Persona;
import co.com.sofka.model.viaje.Viaje;

import java.util.List;
import java.util.stream.Collectors;

public class Convertidor {
    private Convertidor ( ) {
        throw new IllegalStateException ( "Utility class" );
    }

    public static Viaje convertirViajeDataToViaje ( ViajeData viajeData ) {
        return Viaje.builder ( )
                .idViaje ( viajeData.getIdViaje ( ) )
                .tipoViaje ( viajeData.getTipoViaje ( ) )
                .nombreViaje ( viajeData.getNombreViaje ( ) )
                .build ( );
    }

    public static List < Viaje > convertirViajeDataToViajes ( List < ViajeData > viajeData ) {
        return viajeData.stream ( ).map ( Convertidor :: convertirViajeDataToViaje ).collect ( Collectors.toList ( ) );
    }

    public static Persona convertirPersonaDataToPersona ( PersonaData personaData ) {
        return Persona.builder ( )
                .cedula ( personaData.getIdPersona ( ) ).nombre ( personaData.getNombrePersona ( ) )
                .fechaNacimiento ( personaData.getFechaNacimiento ( ) ).tipoSangre ( personaData.getTipoSangre ( ) )
                .viajes ( convertirViajeDataToViajes ( personaData.getViajes ( ) ) )
                .build ( );

    }

    public static List < Persona > convertirPersonaDataToPersonas ( List < PersonaData > personaData ) {
        return personaData.stream ( ).map ( Convertidor :: convertirPersonaDataToPersona ).collect ( Collectors.toList ( ) );
    }


    public static ViajeData convertirViajeToViajeData ( Viaje dominio ) {
        ViajeData viajeData = new ViajeData ( );
        viajeData.setIdViaje ( dominio.getIdViaje ( ) );
        viajeData.setTipoViaje ( dominio.getTipoViaje ( ) );
        viajeData.setNombreViaje ( dominio.getNombreViaje ( ) );
        return viajeData;
    }

    public static List < ViajeData > convertirViajeToViajeData ( List < Viaje > viajes ) {
        return viajes.stream ( ).map ( Convertidor :: convertirViajeToViajeData ).collect ( Collectors.toList ( ) );
    }


    public static PersonaData convertirPersonaToPersonaData ( Persona dominio ) {
        PersonaData personaData = new PersonaData ( );
        personaData.setIdPersona ( dominio.getCedula ( ) );
        personaData.setNombrePersona ( dominio.getNombre ( ) );
        personaData.setFechaNacimiento ( dominio.getFechaNacimiento ( ) );
        personaData.setTipoSangre ( dominio.getTipoSangre ( ) );
        personaData.setViajes ( convertirViajeToViajeData ( dominio.getViajes ( ) ) );
        return personaData;
    }


}
