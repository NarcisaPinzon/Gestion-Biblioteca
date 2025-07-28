package edu.unl.cc.biblioteca.jakarta.bean;

import edu.unl.cc.biblioteca.entidad.Usuario;
import edu.unl.cc.biblioteca.jakarta.domain.UsuarioService;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private Usuario usuario;
    private boolean autenticado = false;

    @EJB
    private UsuarioService usuarioService;

    public String login() {
        Usuario u = usuarioService.buscarPorUsuario(username);
        if (u != null && u.getContrasena().equals(password)) {
            this.usuario = u;
            this.autenticado = true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioActual", u);
            System.out.println("✅ Login exitoso: " + u.getNombre());
            return "busqueda.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrecta", null));
            return null;
        }
    }

    public String logout() {
        System.out.println("🔓 Cerrando sesión de: " + (usuario != null ? usuario.getNombre() : "desconocido"));
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }

    public String irABusqueda() {
        if (autenticado) {
            return "busqueda.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe iniciar sesión para acceder a la búsqueda.", null));
            return null;
        }
    }

// Getters y setters

    public boolean isAutenticado() {
        return autenticado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
