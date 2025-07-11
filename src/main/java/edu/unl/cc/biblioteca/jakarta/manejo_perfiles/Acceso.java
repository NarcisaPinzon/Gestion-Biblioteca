package edu.unl.cc.biblioteca.jakarta.manejo_perfiles;

public class Acceso {
    private String usuario;
    private String clave;

    public Acceso() {}

    public boolean autenticar(String usuario, String clave) {
        return this.usuario.equals(usuario) && this.clave.equals(clave);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}