package com.postwork_dw_java_f2_m2_e8.reactive;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import com.postwork_dw_java_f2_m2_e8.models.Curso;
import com.postwork_dw_java_f2_m2_e8.models.Estudiante;
import com.postwork_dw_java_f2_m2_e8.models.Materia;

public class CalcularPromedioCursoRxTest {
    private static final Curso curso = new Curso();
    private static Materia materia = new Materia();
    private static Estudiante e1 = new Estudiante();
    private static Estudiante e2 = new Estudiante();
    private static Estudiante e3 = new Estudiante();
    private static Double prom;
    static {
        materia.setNombre("Java SE II");
        e1.setNombreCompleto("Daniel Mayen");
        e2.setNombreCompleto("Juan Aldama");
        e3.setNombreCompleto("Esteban Ramirez");
        curso.setCiclo("2023");
        curso.setMateria(materia);
        Map<Estudiante, Integer> calfs = new HashMap<>();
        calfs.put(e1, 5);
        calfs.put(e2, 9);
        calfs.put(e3, 2);
        curso.setCalificaciones(calfs);
        prom = 0.0;

        for (int valor : calfs.values()) {
            prom += valor;
        }
        prom /= calfs.size();
    }

    @Test
    @DisplayName("Promedio")
    void testPromedio() {
        CalcularPromedioCursoRx cp = new CalcularPromedioCursoRx();
        cp.promedio(curso).subscribe(p -> assertThat(p).isEqualTo(prom, within(0.1)));
    }
}
