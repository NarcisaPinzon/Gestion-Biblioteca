package edu.unl.cc.biblioteca.jakarta.bean;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {

    private String rol; // "docente", "estudiante", "invitado"
    private String terminoBusqueda;
    private List<String> resultadosBusqueda;

    @PostConstruct
    public void init() {
        rol = "invitado"; // Se puede cambiar al iniciar sesión
        resultadosBusqueda = new ArrayList<>();
    }

    public void buscarLibros() {
        resultadosBusqueda.clear();
        resultadosBusqueda.add("Libro relacionado con: " + terminoBusqueda);
        resultadosBusqueda.add("Otro libro sobre: " + terminoBusqueda);
    }

    public boolean puedeReservar() {
        return rol.equals("docente") || rol.equals("estudiante");
    }

    public boolean puedeAccederDigitalCompleto() {
        return rol.equals("docente") || rol.equals("estudiante");
    }

    public boolean puedeComentar() {
        return rol.equals("docente") || rol.equals("estudiante");
    }

    public boolean puedeSugerir() {
        return rol.equals("docente");
    }

    public boolean puedeVerHistorial() {
        return !rol.equals("invitado");
    }

    public boolean puedeDevolver() {
        return !rol.equals("invitado");
    }

    public boolean puedeCrearListaLectura() {
        return rol.equals("docente");
    }

    public boolean puedeAccederMaterialExclusivo() {
        return rol.equals("docente");
    }

    // Getters y Setters
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTerminoBusqueda() {
        return terminoBusqueda;
    }

    public void setTerminoBusqueda(String terminoBusqueda) {
        this.terminoBusqueda = terminoBusqueda;
    }

    public List<String> getResultadosBusqueda() {
        return resultadosBusqueda;
    }
}

