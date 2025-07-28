package edu.unl.cc.biblioteca.jakarta.bean;

import edu.unl.cc.biblioteca.entidad.Libro;
import edu.unl.cc.biblioteca.entidad.Usuario;
import edu.unl.cc.biblioteca.jakarta.domain.ReservaService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import edu.unl.cc.biblioteca.jakarta.bean.UsuarioBean;


import java.io.Serializable;
import java.util.*;

@Named("reservaBean")
@ViewScoped
public class ReservaBean implements Serializable {
    @Inject
    private UsuarioBean usuarioBean;

    private static final long serialVersionUID = 1L;

    private List<Libro> librosAReservar;
    private int diasPrestamo = 1;
    private Date fechaLimite;
    private String tipoUsuario; // "docente" o "estudiante"

    @EJB
    private ReservaService reservaService;

    @PostConstruct
    public void init() {
        Object seleccion = FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("librosSeleccionados");
        librosAReservar = (seleccion != null) ? (List<Libro>) seleccion : new ArrayList<>();

        Object tipo = FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("tipoUsuario");
        tipoUsuario = (tipo != null) ? tipo.toString() : "estudiante";

        calcularFechaLimite();
    }

    public void calcularFechaLimite() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, diasPrestamo);
        while (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        fechaLimite = cal.getTime();
    }

    public List<Integer> getDiasDisponibles() {
        int maximoDias = tipoUsuario.equalsIgnoreCase("docente") ? 3 : 2;
        List<Integer> dias = new ArrayList<>();
        for (int i = 1; i <= maximoDias; i++) {
            dias.add(i);
        }
        return dias;
    }

    public String confirmarReserva() {
        try {
            // Validar días
            int maximoDias = tipoUsuario.equalsIgnoreCase("docente") ? 3 : 2;
            if (diasPrestamo > maximoDias) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Límite de días excedido", null));
                return null;
            }

            // Mostrar mensaje sin validar usuario
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Reserva exitosa.", null));

            // Limpiar libros seleccionados
            librosAReservar = new ArrayList<>();

            return null;

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error al confirmar la reserva: " + e.getMessage(), null));
            return null;
        }
    }


    // Getters y Setters

    public List<Libro> getLibrosAReservar() {
        return librosAReservar;
    }

    public void setLibrosAReservar(List<Libro> librosAReservar) {
        this.librosAReservar = librosAReservar;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
        calcularFechaLimite();
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
