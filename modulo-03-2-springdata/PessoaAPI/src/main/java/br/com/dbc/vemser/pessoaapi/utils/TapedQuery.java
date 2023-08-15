package br.com.dbc.vemser.pessoaapi.utils;

import br.com.dbc.vemser.pessoaapi.model.entity.Endereco;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class TapedQuery {

    @PersistenceContext
    private EntityManager em;

    public List<Endereco> customQueryEndereco(Long id) {
        StringBuilder query = new StringBuilder("SELECT e.* FROM VEM_SER.PESSOA_X_PESSOA_ENDERECO ppe INNER JOIN VEM_SER.ENDERECO e on e.ID_ENDERECO = ppe.ID_ENDERECO WHERE ppe.ID_PESSOA = :id");

        TypedQuery<Endereco> typedQuery = em.createQuery(query.toString(), Endereco.class);

        typedQuery.setParameter("id", id);

        return typedQuery.getResultList();
    }

}
