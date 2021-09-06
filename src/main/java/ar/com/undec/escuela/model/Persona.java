package ar.com.undec.escuela.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private String documento;
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private Collection<Clase> clasesById;
    private Tipopersona tipopersonaByTipoPersona;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellido", nullable = false, length = 100)
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "documento", nullable = false, length = 100)
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Basic
    @Column(name = "fechaNacimiento", nullable = true)
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "direccion", nullable = true, length = 100)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "telefono", nullable = true, length = 100)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(id, persona.id) && Objects.equals(nombre, persona.nombre) && Objects.equals(apellido, persona.apellido) && Objects.equals(documento, persona.documento) && Objects.equals(fechaNacimiento, persona.fechaNacimiento) && Objects.equals(direccion, persona.direccion) && Objects.equals(telefono, persona.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, documento, fechaNacimiento, direccion, telefono);
    }

    @OneToMany(mappedBy = "personaByIdPersona")
    public Collection<Clase> getClasesById() {
        return clasesById;
    }

    public void setClasesById(Collection<Clase> clasesById) {
        this.clasesById = clasesById;
    }

    @ManyToOne
    @JoinColumn(name = "tipoPersona", referencedColumnName = "id", nullable = false)
    public Tipopersona getTipopersonaByTipoPersona() {
        return tipopersonaByTipoPersona;
    }

    public void setTipopersonaByTipoPersona(Tipopersona tipopersonaByTipoPersona) {
        this.tipopersonaByTipoPersona = tipopersonaByTipoPersona;
    }
}
