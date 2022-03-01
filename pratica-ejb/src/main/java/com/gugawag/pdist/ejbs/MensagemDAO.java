package com.gugawag.pdist.ejbs;

import com.gugawag.pdist.model.Mensagem;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MensagemDAO {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public void inserir(Mensagem mensagem) {
        entityManager.persist(mensagem);
    }

    public List<Mensagem> listar() {
        return entityManager.createQuery("SELECT a FROM Mensagem a").getResultList();
    }

    public Mensagem pesquisarPorID(long id) {
        return (Mensagem) entityManager.createQuery("SELECT m FROM Mensagem m WHERE m.id = :id ")
                .setParameter("id", id).getSingleResult();
    }
}
