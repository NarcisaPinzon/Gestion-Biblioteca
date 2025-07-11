package edu.unl.cc.biblioteca.jakarta.bean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Named("gestionBean")
@RequestScoped
public class GestionBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String libroIdParaReserva;
    private String usuarioIdParaReserva;
    private String libroIdParaRenovacion;

    private Map<String, Integer> inventarioLibros;

    public GestionBean() {
        inventarioLibros = new HashMap<>();
        inventarioLibros.put("ISBN-1234", 5);
        inventarioLibros.put("ISBN-5678", 2);
    }

    /**
     *
     * @return
     */
    public String reservarLibro() {
        System.out.println("Reservando libro " + libroIdParaReserva + " para usuario " + usuarioIdParaReserva);
        Integer availableCopies = inventarioLibros.getOrDefault(libroIdParaReserva, 0);
        if (availableCopies > 0) {
            inventarioLibros.put(libroIdParaReserva, availableCopies - 1);
            System.out.println("Libro " + libroIdParaReserva + " reservado exitosamente.");
            return "reserva_exitosa.xhtml?faces-redirect=true";
        } else {
            System.out.println("Libro " + libroIdParaReserva + " no disponible para reserva.");
            return "reserva_fallida.xhtml?faces-redirect=true";
        }
    }


    public String renovarLibro() {
        System.out.println("Renovando préstamo del libro: " + libroIdParaRenovacion);
        // This would involve updating a loan record in the database
        System.out.println("Préstamo del libro " + libroIdParaRenovacion + " renovado exitosamente.");
        return "renovacion_exitosa.xhtml?faces-redirect=true";
    }

    /**
     *
     * @param bookId
     * @return
     */
    public int disponibilidad(String bookId) {
        return inventarioLibros.getOrDefault(bookId, 0);
    }

    public String getLibroIdParaReserva() {
        return libroIdParaReserva;
    }

    public void setLibroIdParaReserva(String libroIdParaReserva) {
        this.libroIdParaReserva = libroIdParaReserva;
    }

    public String getUsuarioIdParaReserva() {
        return usuarioIdParaReserva;
    }

    public void setUsuarioIdParaReserva(String usuarioIdParaReserva) {
        this.usuarioIdParaReserva = usuarioIdParaReserva;
    }

    public String getLibroIdParaRenovacion() {
        return libroIdParaRenovacion;
    }

    public void setLibroIdParaRenovacion(String libroIdParaRenovacion) {
        this.libroIdParaRenovacion = libroIdParaRenovacion;
    }
}

