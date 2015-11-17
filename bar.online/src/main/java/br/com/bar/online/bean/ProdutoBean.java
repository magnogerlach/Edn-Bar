package br.com.bar.online.bean;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import br.com.bar.online.conection.JPAUtil;
import br.com.bar.online.domain.Produto;
import br.com.bar.online.enums.TipoProduto;

@ManagedBean
public class ProdutoBean {

	private Produto produto = new Produto();
	private TipoProduto tipoProduto;
	
	public void salva(Produto produto) {
		
	EntityManager em = JPAUtil.getEntityMananger();
	em.getTransaction().begin();
	em.persist(produto);
	em.getTransaction().commit();
	em.close();
	
	}
	
	

	public TipoProduto[] getTipoProdutoArray(){
		return TipoProduto.values();
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
