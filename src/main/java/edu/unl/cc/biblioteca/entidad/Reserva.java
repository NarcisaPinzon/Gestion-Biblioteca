package edu.unl.cc.biblioteca.entidad;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Usuario usuario;

    @ManyToOne(optional = false)
    private Libro libro;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.DATE)
    private Date fechaLimite;

    private String estado; // ACTIVA | PENDIENTE | CANCELADA | DEVUELTO

    // --- Getters & Setters ---

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Libro getLibro() { return libro; }

    public void setLibro(Libro libro) { this.libro = libro; }

    public Date getFechaCreacion() { return fechaCreacion; }

    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public Date getFechaLimite() { return fechaLimite; }

    public void setFechaLimite(Date fechaLimite) { this.fechaLimite = fechaLimite; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }
}
