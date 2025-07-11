package edu.unl.cc.biblioteca.jakarta.modem;
import java.util.HashMap;
import java.util.Map;

public class Gestion {
    private int maxPrestamo;
    private int diasPrestamo;
    private boolean reservar;
    private boolean renovar;
    private boolean accesoDigital;
    private boolean disponibilidad;
    private boolean reserva;

    private Map<String, Boolean> disponibilidadLibros;
    private Map<String, String> reservas;
    private Map<String, String> prestamosActivos;

    public Gestion() {
        this.maxPrestamo = 5;
        this.diasPrestamo = 14;
        this.disponibilidadLibros = new HashMap<>();
        this.reservas = new HashMap<>();
        this.prestamosActivos = new HashMap<>();
    }

    public boolean reservar(String libroId, String usuarioId) {
        if (disponibilidadLibros.getOrDefault(libroId, true)) {
            reservas.put(libroId, usuarioId);
            disponibilidadLibros.put(libroId, false);
            return true;
        }
        return false;
    }

    public boolean renovar(String libroId, String usuarioId) {
        if (prestamosActivos.containsKey(libroId) && prestamosActivos.get(libroId).equals(usuarioId)) {
            if (!reservas.containsKey(libroId) || reservas.get(libroId).equals(usuarioId)) {
                return true;
            }
        }
        return false;
    }

    public boolean disponibilidad(String libroId) {
        return disponibilidadLibros.getOrDefault(libroId, true);
    }

    public boolean accesoDigital(String usuarioId) {
        return true;
    }

    public String operation() {
        return "Operación realizada con éxito";
    }

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

    public boolean isReservar() {
        return reservar;
    }

    public void setReservar(boolean reservar) {
        this.reservar = reservar;
    }

    public boolean isRenovar() {
        return renovar;
    }

    public void setRenovar(boolean renovar) {
        this.renovar = renovar;
    }

    public boolean isAccesoDigital() {
        return accesoDigital;
    }

    public void setAccesoDigital(boolean accesoDigital) {
        this.accesoDigital = accesoDigital;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public boolean isReserva() {
        return reserva;
    }

    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }

    public Map<String, Boolean> getDisponibilidadLibros() {
        return disponibilidadLibros;
    }

    public void setDisponibilidadLibros(Map<String, Boolean> disponibilidadLibros) {
        this.disponibilidadLibros = disponibilidadLibros;
    }

    public Map<String, String> getReservas() {
        return reservas;
    }

    public void setReservas(Map<String, String> reservas) {
        this.reservas = reservas;
    }

    public Map<String, String> getPrestamosActivos() {
        return prestamosActivos;
    }

    public void setPrestamosActivos(Map<String, String> prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }
}


