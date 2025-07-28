package edu.unl.cc.biblioteca.jakarta.bean;
import edu.unl.cc.biblioteca.jakarta.bean.PerfilBean;
import edu.unl.cc.biblioteca.entidad.Usuario;
import edu.unl.cc.biblioteca.jakarta.domain.UsuarioService;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
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
    private boolean registroExitoso = false;

    // INYECCIÓN DEL SERVICIO
    @EJB
    private UsuarioService usuarioService;

    // INYECCIÓN DEL PERFIL SELECCIONADO
    @Inject
    private PerfilBean perfilBean;

    // Acción al presionar "Crear Cuenta"
    public String registrar() {
        try {
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(nombre);
            nuevoUsuario.setApellido(apellido);
            nuevoUsuario.setCorreo(correo);
            nuevoUsuario.setUsuario(usuario);
            nuevoUsuario.setContrasena(contrasena);
            nuevoUsuario.setPerfil(perfilBean.getPerfilSeleccionado());

            usuarioService.registrarUsuario(nuevoUsuario);
            registroExitoso = true;

        } catch (Exception e) {
            e.printStackTrace();
            registroExitoso = false;
        }

        return null; // permanece en la misma vista
    }

    public String irAlLogin() {
        return "login.xhtml?faces-redirect=true";
    }

    // Getters y Setters

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public boolean isRegistroExitoso() { return registroExitoso; }
    public void setRegistroExitoso(boolean registroExitoso) { this.registroExitoso = registroExitoso; }
}
