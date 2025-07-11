package edu.unl.cc.biblioteca.jakarta.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Named("authBean")
@SessionScoped
public class AuthBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private boolean autenticado = false;

    // Simulador de usuarios registrados
    private static final Map<String, String> usuariosRegistrados = new HashMap<>();

    // Lógica para iniciar sesión
    public String login() {
        if (usuariosRegistrados.containsKey(username)
                && usuariosRegistrados.get(username).equals(password)) {
            autenticado = true;
            return "biblioteca.xhtml?faces-redirect=true";
        }
        return "login.xhtml?faces-redirect=true"; // si falla
    }

    // Lógica para registrar
    public String registrar() {
        usuariosRegistrados.put(username, password);
        autenticado = true;
        return "biblioteca.xhtml?faces-redirect=true";
    }

    // Protección de vistas
    public void verificarSesion() throws IOException {
        if (!autenticado) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        }
    }

    // Getters y Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean isAutenticado() { return autenticado; }
}

