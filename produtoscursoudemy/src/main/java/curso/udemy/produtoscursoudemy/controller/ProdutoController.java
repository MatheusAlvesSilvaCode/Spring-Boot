package curso.udemy.produtoscursoudemy.controller;


import curso.udemy.produtoscursoudemy.model.Produto;
import curso.udemy.produtoscursoudemy.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("produtos")
@RestController

public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto Recebido: " + produto);

        var id = UUID.randomUUID().toString();

        produto.setId(id);

        produtoRepository.save(produto);
        return produto;

    }

    @GetMapping("/{id}")
     public Produto obterPorId(@PathVariable("id") String id){
         Optional<Produto> produto = produtoRepository.findById(id);
         return produto.isPresent() ? produto.get() : null; // Temos o produto? se sim pegue get() se não null
     }

     @DeleteMapping("{id}")
     public void deletar( @PathVariable("id") String id){
        produtoRepository.deleteById(id);
     }

     @PutMapping("{id}") // Para atualizar  que já existe.
     public void atualizar(@PathVariable("id") String id,
                           @RequestBody Produto produto){
        produto.setId(id);
         produtoRepository.save(produto);
     }

     @GetMapping
     public List<Produto> buscar(@RequestParam("nome") String nome){
        return produtoRepository.findByNome(nome);
     }
}
