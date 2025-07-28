package edu.unl.cc.biblioteca.jakarta.domain;

import edu.unl.cc.biblioteca.entidad.Libro;
import edu.unl.cc.biblioteca.entidad.Reserva;
import edu.unl.cc.biblioteca.entidad.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Date;
import java.util.List;

@Stateless
public class ReservaService {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void crearReserva(Usuario usuario, List<Libro> libros, Date fechaLimite) {
        if (usuario == null) {
            throw new IllegalStateException("No hay usuario autenticado.");
        }

        // Obtener perfil del usuario
        String perfil = usuario.getPerfil();
        if (perfil == null) {
            throw new IllegalStateException("El perfil del usuario no está definido.");
        }

        int max = perfil.equalsIgnoreCase("docente") ? 3 : 2;

        // Consultar cuántas reservas activas o pendientes ya tiene
        Long yaReservadas = em.createQuery(
                        "SELECT COUNT(r) FROM Reserva r " +
                                "WHERE r.usuario.id = :uid AND r.estado IN ('ACTIVA', 'PENDIENTE')",
                        Long.class)
                .setParameter("uid", usuario.getId())
                .getSingleResult();

        if (yaReservadas + libros.size() > max) {
            throw new IllegalStateException("Superas el límite de reservas permitido (" + max + ").");
        }

        // Crear reservas para cada libro
        for (Libro libro : libros) {
            Reserva r = new Reserva();
            r.setUsuario(usuario);
            r.setLibro(libro);
            r.setFechaCreacion(new Date());
            r.setFechaLimite(fechaLimite);
            r.setEstado("PENDIENTE");
            em.persist(r);
        }
    }
}
