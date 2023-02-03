package co.com.sofka.jpa.persona;


import co.com.sofka.jpa.viaje.ViajeData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "persona")

public class PersonaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;

    @Column(name = "nombre_persona")
    private String nombrePersona;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "tipo_sangre")
    private String tipoSangre;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_persona")
    private List < ViajeData > viajes;


}
