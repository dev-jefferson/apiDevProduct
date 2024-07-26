package br.com.jhsgdev.apiDevProduct.repository;

import br.com.jhsgdev.apiDevProduct.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * ProdutoRepository
 *
 * @author Jefferson Henrique Sousa Galvão
 *
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
