package br.com.jhsgdev.apiDevProduct.controller;

import br.com.jhsgdev.apiDevProduct.model.dto.ProdutoDTO;
import br.com.jhsgdev.apiDevProduct.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *
 * ProdutoController
 *
 * @author Jefferson Henrique Sousa Galvão
 *
 */
@RestController
@RequestMapping("/v1/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> createProduct(@RequestBody ProdutoDTO produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.create(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> updateProduct(@PathVariable Long id,
                                                    @RequestBody @Valid ProdutoDTO produtoDetails) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.update(id, produtoDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto removido com sucesso.");
    }
}
