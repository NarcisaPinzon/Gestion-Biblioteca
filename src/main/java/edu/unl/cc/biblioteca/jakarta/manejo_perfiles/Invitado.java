package edu.unl.cc.biblioteca.jakarta.manejo_perfiles;

public class Invitado extends Perfil {
    private String institucionProcedencia;
    private int tiempoLimiteAcceso; // en días
    private String autorizadoPor;

    public Invitado() {
        this.tipoAcceso = "INVITADO";
    }

    public Invitado(String id, String nombre, String telefono, Acceso accesoDigital,
                    String institucionProcedencia, int tiempoLimiteAcceso, String autorizadoPor) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoAcceso = "INVITADO";
        this.acceso = acceso;
        this.institucionProcedencia = institucionProcedencia;
        this.tiempoLimiteAcceso = tiempoLimiteAcceso;
        this.autorizadoPor = autorizadoPor;
    }

    public String getInstitucionProcedencia() {
        return institucionProcedencia;
    }

    public void setInstitucionProcedencia(String institucionProcedencia) {
        this.institucionProcedencia = institucionProcedencia;
    }

    public int getTiempoLimiteAcceso() {
        return tiempoLimiteAcceso;
    }

    public void setTiempoLimiteAcceso(int tiempoLimiteAcceso) {
        this.tiempoLimiteAcceso = tiempoLimiteAcceso;
    }

    public String getAutorizadoPor() {
        return autorizadoPor;
    }

    public void setAutorizadoPor(String autorizadoPor) {
        this.autorizadoPor = autorizadoPor;
    }

    public boolean accesoVigente(int diasDesdeRegistro) {
        return diasDesdeRegistro <= tiempoLimiteAcceso;
    }
}


