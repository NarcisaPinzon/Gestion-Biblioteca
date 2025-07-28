package edu.unl.cc.biblioteca.dao;
import edu.unl.cc.biblioteca.entidad.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UsuarioDAO {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public void registrar(Usuario usuario) {
        em.persist(usuario);
    }
}
