package br.com.bar.online.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import br.com.bar.online.conection.JPAUtil;
import br.com.bar.online.domain.Produto;
import br.com.bar.online.enums.TipoProduto;

@ManagedBean
public class ProdutoBean {

	private Produto produto = new Produto();
	private TipoProduto tipoProduto;
	private List<Produto> produtos;

	@Transactional(readOnly = false)  
	public void salva(Produto produto) {

		EntityManager em = JPAUtil.getEntityMananger();
		em.getTransaction().begin();
	
		em.persist(produto);
		em.merge(produto);
		em.getTransaction().commit();
		
		em.close();
		
		

	}

	public TipoProduto[] getTipoProdutoArray() {

		return TipoProduto.values();

	}

	public List<Produto> getProdutos() {
		if (this.produtos == null) {
			EntityManager em = JPAUtil.getEntityMananger();
			Query q = em.createQuery("select p from Produto p", Produto.class);

			this.produtos = q.getResultList();
			em.close();
		}
		return produtos;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
