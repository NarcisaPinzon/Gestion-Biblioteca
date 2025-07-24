package edu.unl.cc.biblioteca.dao;

import edu.unl.cc.biblioteca.entidad.Libro;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class LibroDAO {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    public List<Libro> buscarPorTitulo(String termino) {
        return em.createQuery("SELECT l FROM Libro l WHERE LOWER(l.titulo) LIKE :termino", Libro.class)
                .setParameter("termino", "%" + termino.toLowerCase() + "%")
                .getResultList();
    }
}
