package edu.unl.cc.biblioteca.jakarta.bean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Named("perfilBean")
@SessionScoped
public class PerfilBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombrePerfil;
    private String descripcionPerfil;

    public String seleccionarPerfil(String tipo) {
        this.nombrePerfil = tipo;

        switch (tipo) {
            case "Docente":
                this.descripcionPerfil = "Perfil de usuario docente";
                break;
            case "Estudiante":
                this.descripcionPerfil = "Perfil de usuario estudiante";
                break;
            case "Invitado":
                this.descripcionPerfil = "Perfil de usuario invitado";
                break;
            default:
                this.descripcionPerfil = "Perfil desconocido";
        }

        return "perfil.xhtml?faces-redirect=true"; // vuelve a la misma página
    }

    // Getters y Setters

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public String getDescripcionPerfil() {
        return descripcionPerfil;
    }

    public void setDescripcionPerfil(String descripcionPerfil) {
        this.descripcionPerfil = descripcionPerfil;
    }
}