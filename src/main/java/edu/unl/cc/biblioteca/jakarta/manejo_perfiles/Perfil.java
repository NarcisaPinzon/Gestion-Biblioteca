package edu.unl.cc.biblioteca.jakarta.manejo_perfiles;

public class Perfil {
    protected String id;
    protected String tipoAcceso;
    protected String nombre;
    protected String telefono;
    protected Acceso acceso;

    public Perfil() {
    }

    public boolean tieneAccesoDigital() {
        return acceso != null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoAcceso() {
        return tipoAcceso;
    }

    public void setTipoAcceso(String tipoAcceso) {
        this.tipoAcceso = tipoAcceso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Acceso getAcceso() {
        return acceso;
    }

    public void setAcceso(Acceso acceso) {
        this.acceso = acceso;
    }
}
