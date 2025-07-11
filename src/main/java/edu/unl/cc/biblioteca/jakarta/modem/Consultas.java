package edu.unl.cc.biblioteca.jakarta.modem;
import java.util.Date;

public class Consultas {
    private String tipo;
    private String contenido;
    private String respuesta;
    private Date fechaComentario;

    public Consultas() {}

    public void responder(String respuesta) {
        this.respuesta = respuesta;
        this.fechaComentario = new Date();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
}



