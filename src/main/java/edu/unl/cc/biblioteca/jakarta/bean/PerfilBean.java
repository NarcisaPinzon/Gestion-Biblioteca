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

    private List<Perfil> listaPerfiles;

    public PerfilBean() {
        this.listaPerfiles = new ArrayList<>();
        // listaPerfiles.add(new Perfil("Admin", "Administrador del sistema"));
    }


    public String guardar() {
        System.out.println("Guardando perfil: " + nombrePerfil + " - " + descripcionPerfil);
        Perfil nuevoPerfil = new Perfil(nombrePerfil, descripcionPerfil);
        listaPerfiles.add(nuevoPerfil);

        nombrePerfil = null;
        descripcionPerfil = null;

        return "perfiles_creados.xhtml?faces-redirect=true";
    }

    /**
     *
     * @return
     */
    public List<Perfil> getPerfiles() {
        return listaPerfiles;
    }

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

    public static class Perfil implements Serializable {
        private String nombre;
        private String descripcion;

        public Perfil(String nombre, String descripcion) {
            this.nombre = nombre;
            this.descripcion = descripcion;
        }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getDescripcion() { return descripcion; }
        public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    }
}
