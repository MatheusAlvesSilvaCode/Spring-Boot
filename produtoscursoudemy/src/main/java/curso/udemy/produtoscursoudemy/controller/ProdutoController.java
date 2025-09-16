package curso.udemy.produtoscursoudemy.controller;


import curso.udemy.produtoscursoudemy.model.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("produtos")
@RestController

public class ProdutoController {
    @PostMapping
    public void salvar(@RequestBody Produto produto){
        System.out.println("Produto Recebido: " + produto);
    }
}
