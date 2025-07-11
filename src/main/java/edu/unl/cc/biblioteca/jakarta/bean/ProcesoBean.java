package edu.unl.cc.biblioteca.jakarta.bean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Named("procesoBean")
@RequestScoped
public class ProcesoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombreProcesoAIniciar;
    private String idProcesoConsultar;

    private static List<Proceso> historialProcesos = new ArrayList<>();


    public String iniciarProceso() {
        String newProcessId = UUID.randomUUID().toString();
        System.out.println("Iniciando proceso: " + nombreProcesoAIniciar + " con ID: " + newProcessId);

        Proceso nuevoProceso = new Proceso(newProcessId, nombreProcesoAIniciar, "En Ejecución", LocalDateTime.now());
        historialProcesos.add(nuevoProceso);

        nombreProcesoAIniciar = null;
        return null;
    }


    public String obtenerEstadoProceso() {
        for (Proceso p : historialProcesos) {
            if (p.getId().equals(idProcesoConsultar)) {
                return "Estado del proceso " + idProcesoConsultar + ": " + p.getEstado();
            }
        }
        return "Proceso con ID " + idProcesoConsultar + " no encontrado.";
    }


    public List<Proceso> getHistorialProcesos() {
        return historialProcesos;
    }

    public String getNombreProcesoAIniciar() {
        return nombreProcesoAIniciar;
    }

    public void setNombreProcesoAIniciar(String nombreProcesoAIniciar) {
        this.nombreProcesoAIniciar = nombreProcesoAIniciar;
    }

    public String getIdProcesoConsultar() {
        return idProcesoConsultar;
    }

    public void setIdProcesoConsultar(String idProcesoConsultar) {
        this.idProcesoConsultar = idProcesoConsultar;
    }

    public static class Proceso implements Serializable {
        private String id;
        private String nombre;
        private String estado;
        private LocalDateTime fechaInicio;
        private LocalDateTime fechaFin;

        public Proceso(String id, String nombre, String estado, LocalDateTime fechaInicio) {
            this.id = id;
            this.nombre = nombre;
            this.estado = estado;
            this.fechaInicio = fechaInicio;
        }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getEstado() { return estado; }
        public void setEstado(String estado) { this.estado = estado; }
        public LocalDateTime getFechaInicio() { return fechaInicio; }
        public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }
        public LocalDateTime getFechaFin() { return fechaFin; }
        public void setFechaFin(LocalDateTime fechaFin) { this.fechaFin = fechaFin; }
    }
}