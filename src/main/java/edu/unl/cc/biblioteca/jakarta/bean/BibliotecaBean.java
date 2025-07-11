package edu.unl.cc.biblioteca.jakarta.bean;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("bibliotecaBean")
@ViewScoped // Example scope, adjust as needed
public class BibliotecaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    // Attributes for a new user (example)
    private String nombreNuevoUsuario;
    private String idNuevoUsuario;

    // Lists to hold users and loans (for demonstration)
    private List<Usuario> listaUsuarios;
    private List<Prestamo> listaPrestamos;

    public BibliotecaBean() {
        this.listaUsuarios = new ArrayList<>();
        this.listaPrestamos = new ArrayList<>();
        // Initialize with dummy data
        // listaUsuarios.add(new Usuario("Juan Perez", "U001"));
        // listaPrestamos.add(new Prestamo("U001", "Libro A", "2025-07-01"));
    }

    /**
     * Method to retrieve all users.
     * In a real application, this would fetch data from a service/DAO layer.
     * @return A list of users.
     */
    public List<Usuario> getUsuarios() {
        // Logic to retrieve all users
        return listaUsuarios;
    }

    /**
     * Method to add a new user.
     * In a real application, this would interact with a service layer to persist the data.
     */
    public String agregarUsuario() {
        System.out.println("Agregando usuario: " + nombreNuevoUsuario + " (ID: " + idNuevoUsuario + ")");
        Usuario nuevoUsuario = new Usuario(nombreNuevoUsuario, idNuevoUsuario);
        listaUsuarios.add(nuevoUsuario);

        // Clear fields
        nombreNuevoUsuario = null;
        idNuevoUsuario = null;

        return null; // Stay on the same page, or return navigation outcome
    }

    /**
     * Method to retrieve all loans.
     * In a real application, this would fetch data from a service/DAO layer.
     * @return A list of loans.
     */
    public List<Prestamo> getPrestamos() {
        // Logic to retrieve all loans
        return listaPrestamos;
    }

    // --- Getters and Setters for Managed Bean properties ---
    public String getNombreNuevoUsuario() {
        return nombreNuevoUsuario;
    }

    public void setNombreNuevoUsuario(String nombreNuevoUsuario) {
        this.nombreNuevoUsuario = nombreNuevoUsuario;
    }

    public String getIdNuevoUsuario() {
        return idNuevoUsuario;
    }

    public void setIdNuevoUsuario(String idNuevoUsuario) {
        this.idNuevoUsuario = idNuevoUsuario;
    }

    // --- Inner classes for Usuario and Prestamo (example data structures) ---
    public static class Usuario implements Serializable {
        private String nombre;
        private String id;

        public Usuario(String nombre, String id) {
            this.nombre = nombre;
            this.id = id;
        }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
    }

    public static class Prestamo implements Serializable {
        private String usuarioId;
        private String libroTitulo;
        private String fechaPrestamo;

        public Prestamo(String usuarioId, String libroTitulo, String fechaPrestamo) {
            this.usuarioId = usuarioId;
            this.libroTitulo = libroTitulo;
            this.fechaPrestamo = fechaPrestamo;
        }

        public String getUsuarioId() { return usuarioId; }
        public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
        public String getLibroTitulo() { return libroTitulo; }
        public void setLibroTitulo(String libroTitulo) { this.libroTitulo = libroTitulo; }
        public String getFechaPrestamo() { return fechaPrestamo; }
        public void setFechaPrestamo(String fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }
    }
}

