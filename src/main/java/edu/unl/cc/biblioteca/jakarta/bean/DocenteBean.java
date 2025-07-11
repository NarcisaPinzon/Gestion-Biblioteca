package edu.unl.cc.biblioteca.jakarta.bean;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("docenteBean")
@ViewScoped
public class DocenteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombreDocente;
    private String departamentoDocente;

    private List<Docente> listaDocentes;

    public DocenteBean() {
        this.listaDocentes = new ArrayList<>();
        // listaDocentes.add(new Docente("Dr. Smith", "Ciencias"));
    }

    public String guardarDocente() {
        System.out.println("Guardando docente: " + nombreDocente + " del departamento " + departamentoDocente);
        Docente nuevoDocente = new Docente(nombreDocente, departamentoDocente);
        listaDocentes.add(nuevoDocente);

        nombreDocente = null;
        departamentoDocente = null;
        return null;
    }

    public List<Docente> getDocentes() {
        return listaDocentes;
    }

    public String getNombreDocente() { return nombreDocente; }
    public void setNombreDocente(String nombreDocente) { this.nombreDocente = nombreDocente; }
    public String getDepartamentoDocente() { return departamentoDocente; }
    public void setDepartamentoDocente(String departamentoDocente) { this.departamentoDocente = departamentoDocente; }

    public static class Docente implements Serializable {
        private String nombre;
        private String departamento;
        public Docente(String nombre, String departamento) { this.nombre = nombre; this.departamento = departamento; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getDepartamento() { return departamento; }
        public void setDepartamento(String departamento) { this.departamento = departamento; }
    }
}