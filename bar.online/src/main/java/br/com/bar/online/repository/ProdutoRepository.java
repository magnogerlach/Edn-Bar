package br.com.bar.online.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.bar.online.domain.Produto;

@Repository
public class ProdutoRepository {

	private EntityManager entityManager;

	public void save(Produto produto) {
		entityManager.persist(produto);
	}

	public void delete(Produto produto) {
		entityManager.remove(produto);

	}

	public void update(Produto produto) {
		entityManager.merge(produto);

	}

	public Produto findById(Long id) {

		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT p FROM Produto p ");
		jpql.append("WHERE p.id = :id");
		TypedQuery<Produto> query = entityManager.createQuery(jpql.toString(), Produto.class);
		return query.getSingleResult();

	}

}
