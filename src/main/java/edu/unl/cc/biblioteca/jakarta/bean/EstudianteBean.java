package edu.unl.cc.biblioteca.jakarta.bean;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("estudianteBean")
@ViewScoped
public class EstudianteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombreEstudiante;
    private String matriculaEstudiante;

    private List<Estudiante> listaEstudiantes;

    public EstudianteBean() {
        this.listaEstudiantes = new ArrayList<>();
        // listaEstudiantes.add(new Estudiante("Ana Lopez", "12345"));
    }

    public String guardarEstudiante() {
        System.out.println("Guardando estudiante: " + nombreEstudiante + " con matrícula " + matriculaEstudiante);
        Estudiante nuevoEstudiante = new Estudiante(nombreEstudiante, matriculaEstudiante);
        listaEstudiantes.add(nuevoEstudiante);
        nombreEstudiante = null;
        matriculaEstudiante = null;
        return null;
    }

    public List<Estudiante> getEstudiantes() {
        return listaEstudiantes;
    }

    public String getNombreEstudiante() { return nombreEstudiante; }
    public void setNombreEstudiante(String nombreEstudiante) { this.nombreEstudiante = nombreEstudiante; }
    public String getMatriculaEstudiante() { return matriculaEstudiante; }
    public void setMatriculaEstudiante(String matriculaEstudiante) { this.matriculaEstudiante = matriculaEstudiante; }

    public static class Estudiante implements Serializable {
        private String nombre;
        private String matricula;
        public Estudiante(String nombre, String matricula) { this.nombre = nombre; this.matricula = matricula; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getMatricula() { return matricula; }
        public void setMatricula(String matricula) { this.matricula = matricula; }
    }
}