package br.com.bar.online.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.bar.online.conection.JPAUtil;
import br.com.bar.online.domain.Produto;

public class TesteMetodos {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityMananger();

		Produto produto = new Produto();
		produto.setNomeProduto("CocaCola");
		produto.setQtdProduto(12);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(produto);
		tx.commit();
		em.close();
		System.out.println("FIM DE TUDO");
	}

}
