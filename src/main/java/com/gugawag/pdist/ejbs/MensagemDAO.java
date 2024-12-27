package com.gugawag.pdist.ejbs;

import com.gugawag.pdist.model.Mensagem;
import com.gugawag.pdist.model.Usuario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MensagemDAO {

    @PersistenceContext(unitName="bd2")
    private EntityManager em2;

    public void inserir(Mensagem novaMensagem) {
        String mensagemTexto = novaMensagem.getMensagem().toLowerCase();
        if (mensagemTexto.contains("palavrao") || mensagemTexto.contains("palavrao")) {
            throw new RuntimeException("Não é possível inserir mensagens com palavrões!");
        }
        em2.persist(novaMensagem);
    }


    public List<Mensagem> listar() {
        return em2.createQuery("FROM Mensagem").getResultList();
    }

}
