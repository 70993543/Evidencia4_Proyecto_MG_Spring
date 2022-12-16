package pe.com.mg.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadoRegistroDTO {
    private long codigo;
    private String nombre;
    private String apellido;
    private String email;
    private String clave;

    public EmpleadoRegistroDTO(String email) {
        this.email = email;
    }
}

