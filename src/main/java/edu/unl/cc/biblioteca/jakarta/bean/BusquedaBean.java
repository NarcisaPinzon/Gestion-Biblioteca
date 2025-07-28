package edu.unl.cc.biblioteca.jakarta.bean;

import edu.unl.cc.biblioteca.dao.LibroDAO;
import edu.unl.cc.biblioteca.entidad.Libro;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named("busquedaBean")
@ViewScoped
public class BusquedaBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String termino;
    private boolean mostrarResultados = false;
    private List<Libro> resultados;
    private Map<Integer, Boolean> librosSeleccionados = new HashMap<>();
    private String tipoUsuario; // "estudiante" o "docente"

    @Inject
    private LibroDAO libroDAO;

    public BusquedaBean() {
        // Constructor vacío
    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        Object tipo = context.getExternalContext().getSessionMap().get("tipoUsuario");
        if (tipo != null) {
            tipoUsuario = tipo.toString();
        } else {
            tipoUsuario = "estudiante"; // Valor por defecto
        }
    }

    public void buscar() {
        if (termino != null && !termino.trim().isEmpty()) {
            resultados = libroDAO.buscarPorTitulo(termino);
            mostrarResultados = true;
            librosSeleccionados.clear();
            for (Libro libro : resultados) {
                librosSeleccionados.put(libro.getId(), false);
            }
        } else {
            mostrarResultados = false;
            resultados = null;
            librosSeleccionados.clear();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Escribe un término de búsqueda.", null));
        }
    }

    public String irAReserva() {
        List<Libro> seleccionados = resultados.stream()
                .filter(libro -> librosSeleccionados.getOrDefault(libro.getId(), false))
                .collect(Collectors.toList());

        int maximoPermitido = 2; // Límite unificado para todos los usuarios

        if (seleccionados.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Debes seleccionar al menos un libro.", null));
            return null;
        }

        if (seleccionados.size() > maximoPermitido) {
            String mensaje = "Solo puedes reservar dos libros.";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, null));
            return null;
        }

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .put("librosSeleccionados", seleccionados);

        return "reserva.xhtml?faces-redirect=true";
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

    public Map<Integer, Boolean> getLibrosSeleccionados() {
        return librosSeleccionados;
    }

    public void setLibrosSeleccionados(Map<Integer, Boolean> librosSeleccionados) {
        this.librosSeleccionados = librosSeleccionados;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
