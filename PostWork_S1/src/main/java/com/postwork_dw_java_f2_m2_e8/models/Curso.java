package com.postwork_dw_java_f2_m2_e8.models;

import java.util.Map;

import javax.persistence.*;



@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="materias_fk", referencedColumnName = "id")
    private Materia materia;

    @Column(name = "ciclo")
    private String ciclo;

    @ElementCollection
    @CollectionTable(name = "cursos_has_estudiantes", joinColumns = {@JoinColumn(name = "cursos_fk", referencedColumnName = "id")})
    @MapKeyJoinColumn(name = "estudiantes_fk", referencedColumnName = "id")
    @Column(name = "calificacion")
    private Map<Estudiante, Integer> calificaciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Map<Estudiante, Integer> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Map<Estudiante, Integer> calificaciones) {
        this.calificaciones = calificaciones;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((materia == null) ? 0 : materia.hashCode());
        result = prime * result + ((ciclo == null) ? 0 : ciclo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Curso other = (Curso) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (materia == null) {
            if (other.materia != null)
                return false;
        } else if (!materia.equals(other.materia))
            return false;
        if (ciclo == null) {
            if (other.ciclo != null)
                return false;
        } else if (!ciclo.equals(other.ciclo))
            return false;
        return true;
    }
}
