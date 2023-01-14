package br.com.api.produtos_back_end.Controller;

import br.com.api.produtos_back_end.Models.Produto;
import br.com.api.produtos_back_end.Models.Resposta;
import br.com.api.produtos_back_end.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listar")
    public Iterable<Produto> listar(){
        return produtoService.listar();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?>cadastrar(@RequestBody Produto produto){
        return produtoService.cadastrarAlterar(produto, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?>alterar(@RequestBody Produto produto){
        return produtoService.cadastrarAlterar(produto, "alterar");
    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<Resposta>remover(@PathVariable Long codigo){
        return produtoService.remover(codigo);
    }

    @GetMapping ("/")
    public String rota(){
        return "API de produtos funcionando!";

    }
}
