package edu.unl.cc.biblioteca.jakarta.domain;

import edu.unl.cc.biblioteca.entidad.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless
public class UsuarioService {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void registrarUsuario(Usuario usuario) {
        if (usuario != null) em.persist(usuario);
    }

    public Usuario buscarPorUsuario(String nombreUsuario) {
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :usuario", Usuario.class)
                    .setParameter("usuario", nombreUsuario.trim())
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Usuario buscarPorCorreo(String correo) {
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.correo = :correo", Usuario.class)
                    .setParameter("correo", correo.trim())
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    /** Si quieres permitir login con usuario O correo en el mismo campo */
    public Usuario buscarPorLogin(String login) {
        try {
            return em.createQuery("""
                    SELECT u FROM Usuario u
                    WHERE lower(u.usuario) = :login OR lower(u.correo) = :login
                """, Usuario.class)
                    .setParameter("login", login.trim().toLowerCase())
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
