package edu.unl.cc.biblioteca.jakarta.bean;
import java.io.Serializable;
import java.time.LocalDate;

public class PrestamoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String usuarioId;
    private String libroId;
    private LocalDate fechaInicio;
    private LocalDate fechaDevolucion;

    public PrestamoBean() {
    }

    public PrestamoBean(String id, String usuarioId, String libroId, LocalDate fechaInicio, LocalDate fechaDevolucion) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = fechaDevolucion;
    }

    // ===== GETTERS Y SETTERS =====

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getLibroId() {
        return libroId;
    }

    public void setLibroId(String libroId) {
        this.libroId = libroId;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "PrestamoBean{" +
                "id='" + id + '\'' +
                ", usuarioId='" + usuarioId + '\'' +
                ", libroId='" + libroId + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}
