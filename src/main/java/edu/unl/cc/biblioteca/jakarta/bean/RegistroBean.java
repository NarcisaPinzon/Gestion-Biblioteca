package edu.unl.cc.biblioteca.jakarta.bean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("registroBean")
@SessionScoped
public class RegistroBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String apellido;
    private String correo;
    private String usuario;
    private String contrasena;

    private boolean registroExitoso = false; // NUEVO

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isRegistroExitoso() {
        return registroExitoso;
    }

    public void setRegistroExitoso(boolean registroExitoso) {
        this.registroExitoso = registroExitoso;
    }

    // Acción al presionar "Crear Cuenta"
    public String registrar() {
        System.out.println("=== REGISTRO DE USUARIO ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Correo: " + correo);
        System.out.println("Usuario: " + usuario);
        System.out.println("Contraseña: " + contrasena);

        registroExitoso = true; // Mostrar mensaje y botón

        return null; // NO redirige automáticamente
    }
}
