package edu.unl.cc.biblioteca.jakarta.modem;

public class Reportes {
    private String prestado;
    private String reserva;
    private String pendiente;
    private String devolucion;

    public Reportes() {}

    public String prestado(String libroId) {
        return "Libro " + libroId + " está prestado.";
    }

    public String reserva(String libroId) {
        return "Libro " + libroId + " está reservado.";
    }

    public String pendiente(String usuarioId) {
        return "Usuario " + usuarioId + " tiene préstamos pendientes.";
    }

    public String devolucion(String libroId) {
        return "Libro " + libroId + " fue devuelto correctamente.";
    }

    public String getPrestado() {
        return prestado;
    }

    public void setPrestado(String prestado) {
        this.prestado = prestado;
    }

    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    public String getPendiente() {
        return pendiente;
    }

    public void setPendiente(String pendiente) {
        this.pendiente = pendiente;
    }

    public String getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(String devolucion) {
        this.devolucion = devolucion;
    }
}
