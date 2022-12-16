package pe.com.mg.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EmpleadoEntity")
@Table(name = "empleado", uniqueConstraints
        = @UniqueConstraint(columnNames = "coremp"))

public class EmpleadoEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codemp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nomemp")
    private String nombre;
    @Column(name = "apeemp")
    private String apellido;
    @Column(name = "coremp")
    private String email;
    @Column(name = "claemp")
    private String clave;
    @ManyToMany(fetch = FetchType.EAGER,
                cascade = CascadeType.ALL)
    @JoinTable(
            name = "empleado_rol",
            joinColumns = @JoinColumn(
                    name = "codemp",
                    referencedColumnName = "codemp"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "codrol",
                    referencedColumnName = "codrol"
            )
    )
    private Collection<RolEntity> rol;

    public EmpleadoEntity(String nombre, String apellido, String email, String clave, Collection<RolEntity> rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.clave = clave;
        this.rol = rol;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Collection<RolEntity> getRol() {
        return rol;
    }

    public void setRol(Collection<RolEntity> rol) {
        this.rol = rol;
    }
}

