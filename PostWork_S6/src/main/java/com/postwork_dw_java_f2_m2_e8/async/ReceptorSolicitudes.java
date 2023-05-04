package com.postwork_dw_java_f2_m2_e8.async;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ReceptorSolicitudes implements Runnable {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    private boolean enEje = false;
    private Queue<SolicitudEstudiante> solicitudPendiente = new LinkedList<>();
    private final NotificadorInscripcion worker;

    public ReceptorSolicitudes(NotificadorInscripcion worker) {
        this.worker = worker;
    }

    @Override
    public void run() {
        try {
            while (enEje || !solicitudPendiente.isEmpty()) {
                SolicitudEstudiante solicitud = solicitudPendiente.poll();
                if (solicitud == null) {
                    System.out.println(ANSI_YELLOW + "Esperando..." + ANSI_RESET);
                    TimeUnit.SECONDS.sleep(1);
                    continue;
                }
                worker.notificar(solicitud);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void iniciar() {
        this.enEje = true;
        new Thread(this).start();
    }

    public void detener() {
        this.enEje = false;
    }

    public void registrarEvento(SolicitudEstudiante evento) {
        solicitudPendiente.add(evento);
    }

    public boolean isEnEjecucion() {
        return enEje;
    }
}
