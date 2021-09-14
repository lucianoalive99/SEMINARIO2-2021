package ar.com.undec.escuela.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Clase {
    private Integer id;
    private String descripcion;
    private Curso cursoByIdCurso;
    private Materia materiaByIdMateria;
    private Persona personaByIdPersona;
    private Ciclolectivo ciclolectivoByIdCicloLectivo;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "descripcion", nullable = true, length = 100)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clase clase = (Clase) o;
        return Objects.equals(id, clase.id) && Objects.equals(descripcion, clase.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion);
    }

    @ManyToOne
    @JoinColumn(name = "idCurso", referencedColumnName = "id", nullable = false)
    public Curso getCursoByIdCurso() {
        return cursoByIdCurso;
    }

    public void setCursoByIdCurso(Curso cursoByIdCurso) {
        this.cursoByIdCurso = cursoByIdCurso;
    }

    @ManyToOne
    @JoinColumn(name = "idMateria", referencedColumnName = "id", nullable = false)
    public Materia getMateriaByIdMateria() {
        return materiaByIdMateria;
    }

    public void setMateriaByIdMateria(Materia materiaByIdMateria) {
        this.materiaByIdMateria = materiaByIdMateria;
    }

    @ManyToOne
    @JoinColumn(name = "idPersona", referencedColumnName = "id", nullable = false)
    public Persona getPersonaByIdPersona() {
        return personaByIdPersona;
    }

    public void setPersonaByIdPersona(Persona personaByIdPersona) {
        this.personaByIdPersona = personaByIdPersona;
    }

    @ManyToOne
    @JoinColumn(name = "idCicloLectivo", referencedColumnName = "id", nullable = false)
    public Ciclolectivo getCiclolectivoByIdCicloLectivo() {
        return ciclolectivoByIdCicloLectivo;
    }

    public void setCiclolectivoByIdCicloLectivo(Ciclolectivo ciclolectivoByIdCicloLectivo) {
        this.ciclolectivoByIdCicloLectivo = ciclolectivoByIdCicloLectivo;
    }
}
