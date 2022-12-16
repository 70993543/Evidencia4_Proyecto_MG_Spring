package pe.com.mg.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ClienteEntity")
@Table(name = "cliente")

public class ClienteEntity implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;
    @Id
    @Column(name = "codcl")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nomcl")
    private String nombre;
    @Column(name = "apecl")
    private String apellido;
    @Column(name = "celcl")
    private String celular;
    @Column(name = "sexcl")
    private String sexo;
    @Column(name = "dircl")
    private String direccion;
    @Column(name = "estcl")
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "coddis", nullable = false)
    private DistritoEntity distrito;

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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public DistritoEntity getDistrito() {
        return distrito;
    }

    public void setDistrito(DistritoEntity distrito) {
        this.distrito = distrito;
    }
}
