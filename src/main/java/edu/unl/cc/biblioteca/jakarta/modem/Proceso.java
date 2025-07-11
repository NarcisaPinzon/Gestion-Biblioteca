package edu.unl.cc.biblioteca.jakarta.modem;
import java.util.Date;

public class Proceso {
    private String registroUso;
    private String libro;
    private String accion;
    private Date fecha;

    public Proceso() {}

    public void registrar(String libro, String accion) {
        this.registroUso = "Registro de acción: " + accion;
        this.libro = libro;
        this.accion = accion;
        this.fecha = new Date();
    }

    public String getRegistroUso() {
        return registroUso;
    }

    public void setRegistroUso(String registroUso) {
        this.registroUso = registroUso;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
