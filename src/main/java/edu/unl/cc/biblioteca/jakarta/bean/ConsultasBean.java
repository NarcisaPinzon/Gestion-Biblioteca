package edu.unl.cc.biblioteca.jakarta.bean;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("consultasBean")
@ViewScoped
public class ConsultasBean implements Serializable {

    private static final long serialVersionUID = 1L;

    // Renombrados para coincidir con XHTML
    private String tipo;      // antes: asuntoConsulta
    private String contenido; // antes: mensajeConsulta
    private String usuarioConsulta; // Se puede mantener

    private List<Consulta> listaConsultas;

    public ConsultasBean() {
        this.listaConsultas = new ArrayList<>();
    }

    // Método renombrado para coincidir con la vista
    public String enviar() {
        System.out.println("Enviando consulta: Tipo='" + tipo + "', Contenido='" + contenido + "', Usuario='" + usuarioConsulta + "'");
        Consulta nuevaConsulta = new Consulta(tipo, contenido, usuarioConsulta);
        listaConsultas.add(nuevaConsulta);

        tipo = null;
        contenido = null;

        System.out.println("Consulta enviada exitosamente.");
        return "consulta_enviada.xhtml?faces-redirect=true";
    }

    // Getters y setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getUsuarioConsulta() {
        return usuarioConsulta;
    }

    public void setUsuarioConsulta(String usuarioConsulta) {
        this.usuarioConsulta = usuarioConsulta;
    }

    public List<Consulta> getConsultas() {
        return listaConsultas;
    }

    // Clase interna Consulta
    public static class Consulta implements Serializable {
        private String asunto;
        private String mensaje;
        private String usuario;

        public Consulta(String asunto, String mensaje, String usuario) {
            this.asunto = asunto;
            this.mensaje = mensaje;
            this.usuario = usuario;
        }

        public String getAsunto() {
            return asunto;
        }

        public void setAsunto(String asunto) {
            this.asunto = asunto;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }
    }
}
