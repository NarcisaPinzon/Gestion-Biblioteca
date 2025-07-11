package edu.unl.cc.biblioteca.jakarta.manejo_perfiles;

public class Docente extends Perfil {
    private String departamento;
    private String titulo;
    private String tipoContrato;

    public Docente() {
        this.tipoAcceso = "DOCENTE";
    }

    public Docente(String id, String nombre, String telefono, Acceso acceso,
                   String departamento, String titulo, String tipoContrato) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoAcceso = "DOCENTE";
        this.acceso = acceso;
        this.departamento = departamento;
        this.titulo = titulo;
        this.tipoContrato = tipoContrato;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
}



