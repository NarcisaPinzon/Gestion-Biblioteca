package edu.unl.cc.biblioteca.jakarta.bean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("perfilBean")
@SessionScoped
public class PerfilBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String perfilSeleccionado;

    // Asegurar que se pasa el perfil
    public String seleccionarPerfil(String tipo) {
        this.perfilSeleccionado = tipo.toLowerCase(); // docente o estudiante
        return "registro.xhtml?faces-redirect=true&perfil=" + perfilSeleccionado;
    }

    public String getPerfilSeleccionado() {
        return perfilSeleccionado;
    }

    public void setPerfilSeleccionado(String perfilSeleccionado) {
        this.perfilSeleccionado = perfilSeleccionado;
    }
}
