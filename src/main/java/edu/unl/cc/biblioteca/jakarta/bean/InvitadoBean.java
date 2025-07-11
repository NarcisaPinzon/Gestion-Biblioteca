package edu.unl.cc.biblioteca.jakarta.bean;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("invitadoBean")
@ViewScoped
public class InvitadoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombreInvitado;
    private String emailInvitado;

    private List<Invitado> listaInvitados;

    public InvitadoBean() {
        this.listaInvitados = new ArrayList<>();
        // listaInvitados.add(new Invitado("Carlos Garcia", "carlos.garcia@unl.edu.ec"));
    }

    public String guardarInvitado() {
        System.out.println("Guardando invitado: " + nombreInvitado + " con email " + emailInvitado);
        Invitado nuevoInvitado = new Invitado(nombreInvitado, emailInvitado);
        listaInvitados.add(nuevoInvitado);
        nombreInvitado = null;
        emailInvitado = null;
        return null;
    }

    public List<Invitado> getInvitados() {
        return listaInvitados;
    }

    public String getNombreInvitado() { return nombreInvitado; }
    public void setNombreInvitado(String nombreInvitado) { this.nombreInvitado = nombreInvitado; }
    public String getEmailInvitado() { return emailInvitado; }
    public void setEmailInvitado(String emailInvitado) { this.emailInvitado = emailInvitado; }

    public static class Invitado implements Serializable {
        private String nombre;
        private String email;
        public Invitado(String nombre, String email) { this.nombre = nombre; this.email = email; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }
}
