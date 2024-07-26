package br.com.jhsgdev.apiDevProduct.service;

import br.com.jhsgdev.apiDevProduct.exception.ObjectNotFoundException;
import br.com.jhsgdev.apiDevProduct.model.dto.ProdutoDTO;
import br.com.jhsgdev.apiDevProduct.model.entity.Produto;
import br.com.jhsgdev.apiDevProduct.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * ProdutoService
 *
 * @author Jefferson Henrique Sousa Galvão
 *
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> getAll() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().map(this::toDto).toList();
    }

    public ProdutoDTO getById(Long id) {
        var entity = produtoRepository.findById(id);
        entity.orElseThrow(() -> this.messageNotfound(id));
        return this.toDto(entity.get());
    }

    public ProdutoDTO create(ProdutoDTO produto) {
        var entity = new Produto();
        BeanUtils.copyProperties(produto, entity);
        return this.toDto(produtoRepository.save(entity));
    }

    public ProdutoDTO update(Long id, ProdutoDTO produtoDetails) {
        var entity = produtoRepository.findById(id)
        .map(produto -> {
            produto.setNome(produtoDetails.nome());
            produto.setReponsavel(produtoDetails.reponsavel());
            produto.setCategoria(produtoDetails.categoria());
            return produtoRepository.save(produto);
        }).orElseThrow(() ->this.messageNotfound(id));
        return this.toDto(entity);
    }

    public void delete(Long id) {
        var entity = produtoRepository.findById(id).
                orElseThrow(() -> this.messageNotfound(id));
        produtoRepository.delete(entity);
    }

    private ProdutoDTO toDto(Produto entity){
        return new ProdutoDTO(
            entity.getId(),
            entity.getNome(),
            entity.getReponsavel(),
            entity.getData_criacao(),
            entity.getData_modificacao(),
            entity.getCategoria()
        );
    }

    private ObjectNotFoundException messageNotfound(Long id) {
        return new ObjectNotFoundException("O Produto de Id: " + id + ", não foi encontrado!");
    }
}
