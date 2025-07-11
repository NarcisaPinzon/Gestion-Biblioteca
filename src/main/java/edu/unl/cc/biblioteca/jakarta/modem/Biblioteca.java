package edu.unl.cc.biblioteca.jakarta.modem;
import edu.unl.cc.biblioteca.jakarta.manejo_perfiles.Perfil;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Perfil> usuarios;
    private List<String> prestamosActivos;

    public Biblioteca() {
        this.usuarios = new ArrayList<>();
        this.prestamosActivos = new ArrayList<>();
    }

    public void agregarUsuario(Perfil perfil) {
        usuarios.add(perfil);
    }

    public void registrarPrestamo(String libroId) {
        prestamosActivos.add(libroId);
    }

    // Getters y setters
    public List<Perfil> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Perfil> usuarios) {
        this.usuarios = usuarios;
    }

    public List<String> getPrestamosActivos() {
        return prestamosActivos;
    }

    public void setPrestamosActivos(List<String> prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }
}


