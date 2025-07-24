package edu.unl.cc.biblioteca.jakarta.bean;

import edu.unl.cc.biblioteca.dao.LibroDAO;
import edu.unl.cc.biblioteca.entidad.Libro;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("busquedaBean")
@ViewScoped
public class BusquedaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String termino;
    private boolean mostrarResultados = false;
    private List<Libro> resultados;

    @Inject
    private LibroDAO libroDAO;

    public void buscar() {
        if (termino != null && !termino.trim().isEmpty()) {
            resultados = libroDAO.buscarPorTitulo(termino);
            mostrarResultados = true;
        } else {
            mostrarResultados = false;
            resultados = null;
        }
    }

    // Getters y Setters
    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public boolean isMostrarResultados() {
        return mostrarResultados;
    }

    public void setMostrarResultados(boolean mostrarResultados) {
        this.mostrarResultados = mostrarResultados;
    }

    public List<Libro> getResultados() {
        return resultados;
    }

    public void setResultados(List<Libro> resultados) {
        this.resultados = resultados;
    }
}
