package edu.unl.cc.biblioteca.jakarta.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Named("gestionBean")
@SessionScoped
public class GestionBean implements Serializable {

    private static final long serialVersionUID = 1L;

    // Parámetros del sistema
    private int maxPrestamo = 5;
    private int diasPrestamo = 14;

    // Datos de formulario
    private String usuarioId;
    private String libroId;
    private String libroBuscado;
    private String idPrestamo;
    private int diasAdicionales;

    // Gestión de libros y préstamos
    private Map<String, Integer> inventarioLibros;
    private Map<String, PrestamoBean> prestamosActivos;
    private Map<String, Boolean> accesoDigitalUsuarios;

    // Mensaje de operación
    private String mensajeUsuario;

    public GestionBean() {
        inventarioLibros = new HashMap<>();
        prestamosActivos = new HashMap<>();
        accesoDigitalUsuarios = new HashMap<>();

        inventarioLibros.put("ISBN-1234", 5);
        inventarioLibros.put("ISBN-5678", 0);
    }

    // ========== FUNCIONES DE PRÉSTAMO ==========

    public String prestarLibro() {
        int disponibles = inventarioLibros.getOrDefault(libroId, 0);
        if (disponibles > 0 && contarPrestamosUsuario(usuarioId) < maxPrestamo) {
            LocalDate fechaInicio = LocalDate.now();
            LocalDate fechaDevolucion = fechaInicio.plusDays(diasPrestamo);
            String id = UUID.randomUUID().toString();

            prestamosActivos.put(id, new PrestamoBean(id, usuarioId, libroId, fechaInicio, fechaDevolucion));
            inventarioLibros.put(libroId, disponibles - 1);
            mensajeUsuario = "Libro prestado correctamente. ID del préstamo: " + id;
        } else {
            mensajeUsuario = disponibles == 0
                    ? "El libro no está disponible."
                    : "Has alcanzado el límite máximo de préstamos.";
        }
        return null;
    }

    public String renovarPrestamo() {
        PrestamoBean p = prestamosActivos.get(idPrestamo);
        if (p != null && p.getUsuarioId().equals(usuarioId)) {
            p.setFechaDevolucion(p.getFechaDevolucion().plusDays(diasAdicionales));
            mensajeUsuario = "Préstamo renovado hasta " + p.getFechaDevolucion();
        } else {
            mensajeUsuario = "No se encontró el préstamo para renovar.";
        }
        return null;
    }

    // ========== GESTIÓN DE ACCESO DIGITAL ==========

    public String alternarAccesoDigital() {
        boolean tieneAcceso = accesoDigitalUsuarios.getOrDefault(usuarioId, false);
        accesoDigitalUsuarios.put(usuarioId, !tieneAcceso);
        mensajeUsuario = tieneAcceso ? "Acceso digital revocado." : "Acceso digital activado.";
        return null;
    }

    public boolean tieneAccesoDigital(String usuario) {
        return accesoDigitalUsuarios.getOrDefault(usuario, false);
    }

    // ========== DISPONIBILIDAD Y RESERVA ==========

    public String verificarDisponibilidad() {
        int disponibles = inventarioLibros.getOrDefault(libroBuscado, 0);
        mensajeUsuario = disponibles > 0 ? "Disponible: " + disponibles : "No disponible";
        return null;
    }

    // ========== UTILITARIOS ==========

    public int contarPrestamosUsuario(String usuario) {
        return (int) prestamosActivos.values().stream()
                .filter(p -> p.getUsuarioId().equals(usuario))
                .count();
    }

    // ========== GETTERS / SETTERS ==========

    public int getMaxPrestamo() {
        return maxPrestamo;
    }

    public void setMaxPrestamo(int maxPrestamo) {
        this.maxPrestamo = maxPrestamo;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
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

    public String getLibroBuscado() {
        return libroBuscado;
    }

    public void setLibroBuscado(String libroBuscado) {
        this.libroBuscado = libroBuscado;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getDiasAdicionales() {
        return diasAdicionales;
    }

    public void setDiasAdicionales(int diasAdicionales) {
        this.diasAdicionales = diasAdicionales;
    }

    public String getMensajeUsuario() {
        return mensajeUsuario;
    }

    public void setMensajeUsuario(String mensajeUsuario) {
        this.mensajeUsuario = mensajeUsuario;
    }

    public Map<String, Integer> getInventarioLibros() {
        return inventarioLibros;
    }

    public Map<String, PrestamoBean> getPrestamosActivos() {
        return prestamosActivos;
    }
}
