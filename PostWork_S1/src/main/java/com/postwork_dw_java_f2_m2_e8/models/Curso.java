package com.postwork_dw_java_f2_m2_e8.models;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="materias_fk",referencedColumnName = "id")
    private Materia materia;
    private String ciclo;

    @ElementCollection
    @CollectionTable(name = "cursos_has_estudiantes", joinColumns = {@JoinColumn (name="cursos_fk",referencedColumnName = "id")})
    @MapKeyJoinColumn(name = "estudiantes_fk", referencedColumnName = "id")
    @Column(name = "calificacion")
    private Map<Estudiante, Integer> calificaciones;

    public Map<Estudiante, Integer> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Map<Estudiante, Integer> calificaciones) {
        this.calificaciones = calificaciones;
    }

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
}
