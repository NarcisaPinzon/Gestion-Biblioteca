package edu.unl.cc.biblioteca.jakarta.bean;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("consultasBean")
@ViewScoped // Example scope, adjust as needed
public class ConsultasBean implements Serializable {

    private static final long serialVersionUID = 1L;

    // Attributes for a new consultation (example)
    private String asuntoConsulta;
    private String mensajeConsulta;
    private String usuarioConsulta; // Who is sending the query

    // List to hold consultations (for demonstration)
    private List<Consulta> listaConsultas;

    public ConsultasBean() {
        this.listaConsultas = new ArrayList<>();
        // listaConsultas.add(new Consulta("Problema con préstamo", "No puedo renovar mi libro.", "U001"));
    }

    /**
     *
     * @return
     */
    public String enviarConsulta() {
        System.out.println("Enviando consulta de " + usuarioConsulta + ": Asunto='" + asuntoConsulta + "', Mensaje='" + mensajeConsulta + "'");
        Consulta nuevaConsulta = new Consulta(asuntoConsulta, mensajeConsulta, usuarioConsulta);
        listaConsultas.add(nuevaConsulta);

        asuntoConsulta = null;
        mensajeConsulta = null;

        System.out.println("Consulta enviada exitosamente.");
        return "consulta_enviada.xhtml?faces-redirect=true";
    }


    public List<Consulta> getConsultas() {
        // Logic to retrieve all consultations
        return listaConsultas;
    }

    public String getAsuntoConsulta() {
        return asuntoConsulta;
    }

    public void setAsuntoConsulta(String asuntoConsulta) {
        this.asuntoConsulta = asuntoConsulta;
    }

    public String getMensajeConsulta() {
        return mensajeConsulta;
    }

    public void setMensajeConsulta(String mensajeConsulta) {
        this.mensajeConsulta = mensajeConsulta;
    }

    public String getUsuarioConsulta() {
        return usuarioConsulta;
    }

    public void setUsuarioConsulta(String usuarioConsulta) {
        this.usuarioConsulta = usuarioConsulta;
    }

    public static class Consulta implements Serializable {
        private String asunto;
        private String mensaje;
        private String usuario;

        public Consulta(String asunto, String mensaje, String usuario) {
            this.asunto = asunto;
            this.mensaje = mensaje;
            this.usuario = usuario;
        }

        public String getAsunto() { return asunto; }
        public void setAsunto(String asunto) { this.asunto = asunto; }
        public String getMensaje() { return mensaje; }
        public void setMensaje(String mensaje) { this.mensaje = mensaje; }
        public String getUsuario() { return usuario; }
        public void setUsuario(String usuario) { this.usuario = usuario; }
    }
}

