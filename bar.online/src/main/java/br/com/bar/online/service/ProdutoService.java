package br.com.bar.online.service;

/**
 * Classe onde foram definidos os serviços dos metodos de salvar, atualizar, buscar, deletar.
 * @author Magno Gerlach
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bar.online.domain.Produto;
import br.com.bar.online.repository.ProdutoRepository;

@Service
@Transactional
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public void save(Produto produto) {
		repository.save(produto);
	}

	public void delete(Produto produto) {
		repository.delete(produto);

	}

	public void update(Produto produto) {
		repository.update(produto);
	}

	public Produto findById(Long id) {
		return repository.findById(id);
	}

}
