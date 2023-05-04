package com.postwork_dw_java_f2_m2_e8.async;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.postwork_dw_java_f2_m2_e8.models.Curso;
import com.postwork_dw_java_f2_m2_e8.models.Estudiante;
import com.postwork_dw_java_f2_m2_e8.models.Materia;

public class InscripcionAlumnos {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";

    private static Curso crearCurso(Random r, String nombreMateria, Long id) {
        Curso curso = new Curso();
        Materia materia = new Materia();

        materia.setNombre(nombreMateria);
        curso.setId(id);
        curso.setMateria(materia);
        return curso;
    }

    private static SolicitudEstudiante[] crearSolicitud() {
        Random r = new Random();
        Curso[] cursos = new Curso[] {
                crearCurso(r, "Java SE I", 1L),
                crearCurso(r, "Java SE II", 2L),
                crearCurso(r, "Java Backend I", 3L),
                crearCurso(r, "Java Backend II", 4L),
                crearCurso(r, "Mysql I", 5L)
        };

        SolicitudEstudiante[] solicitudes = new SolicitudEstudiante[20];
        solicitudes[19] = new SolicitudEstudiante();
        String[] nombresList = { "Juan", "Maria", "Mario", "Rosa", "Benancio", "Belen", "Ricardo", "Lupita" };
        String[] apellidoList = { "Martinez", "Garza", "Soza", "Montes de oca", "Vallesteros", "Espinoza", "Victoria",
                "Reyes" };
        for (int i = 0; i < 19; i++) {
            Estudiante e = new Estudiante();
            e.setNombreCompleto(nombresList[r.nextInt(nombresList.length - 1)] + " "
                    + apellidoList[r.nextInt(apellidoList.length - 1)] + " "
                    + apellidoList[r.nextInt(apellidoList.length - 1)]);
            e.setId((long) i);
            solicitudes[i] = new SolicitudEstudiante(e, cursos[r.nextInt(cursos.length)]);
        }
        return solicitudes;
    }

    public static void main(String[] args) {
        Random r = new Random();
        ReceptorSolicitudes eLoop = new ReceptorSolicitudes(solicitud -> {
            if (solicitud.getEstudiante() == null || solicitud.getCurso() == null) {
                System.out.println(ANSI_RED + "Faltan datos para hacer la solicitud." + ANSI_RESET);
            }
            System.out.println(ANSI_GREEN + "El estudiante: " + ANSI_CYAN
                    + solicitud.getEstudiante().getNombreCompleto() + ANSI_GREEN + ", Se ha registrado en curso de: "
                    + ANSI_CYAN + solicitud.getCurso().getMateria().getNombre() + ANSI_RESET);
        });

        eLoop.iniciar();
        SolicitudEstudiante[] solicitudes = crearSolicitud();
        for (SolicitudEstudiante s : solicitudes) {
            eLoop.registrarEvento(s);
            try {
                TimeUnit.MILLISECONDS.sleep(r.nextInt(200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        eLoop.detener();
    }
}
