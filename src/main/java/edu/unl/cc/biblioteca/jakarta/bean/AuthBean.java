package edu.unl.cc.biblioteca.jakarta.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@Named("authBean")
@SessionScoped
public class AuthBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private boolean autenticado = false;

    public String login() {
        if (username != null && password != null
                && username.length() <= 10
                && password.length() == 12) {
            autenticado = true;
            return "busqueda.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Usuario o contraseña incorrecta", null));
            return null; // Mantenerse en la misma página
        }
    }

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
