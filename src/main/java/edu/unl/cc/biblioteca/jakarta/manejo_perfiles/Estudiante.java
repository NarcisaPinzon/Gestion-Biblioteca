package edu.unl.cc.biblioteca.jakarta.manejo_perfiles;

public class Estudiante extends Perfil {
    private String carrera;
    private int nivel;
    private boolean matriculaActiva;

    public Estudiante() {
        this.tipoAcceso = "ESTUDIANTE";
    }

    public Estudiante(String id, String nombre, String telefono, Acceso acceso,
                      String carrera, int nivel, boolean matriculaActiva) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoAcceso = "ESTUDIANTE";
        this.acceso = acceso;
        this.carrera = carrera;
        this.nivel = nivel;
        this.matriculaActiva = matriculaActiva;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean isMatriculaActiva() {
        return matriculaActiva;
    }

    public void setMatriculaActiva(boolean matriculaActiva) {
        this.matriculaActiva = matriculaActiva;
    }
}
