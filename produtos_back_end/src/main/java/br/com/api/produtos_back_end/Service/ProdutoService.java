package br.com.api.produtos_back_end.Service;

import br.com.api.produtos_back_end.Models.Produto;
import br.com.api.produtos_back_end.Models.Resposta;
import br.com.api.produtos_back_end.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private Resposta resposta;

    //Método para listar todos os produtos
    public Iterable<Produto>listar(){
        return produtoRepository.findAll();
    }

    //Método para cadastrar produtos
    public ResponseEntity<?>cadastrarAlterar(Produto produto, String acao){
        if(produto.getNome().equals("")){
            resposta.setMensagem("O nome do produto é obrigatório!");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
        }else if(produto.getMarca().equals("")){
            resposta.setMensagem(("O nome da marca é obrigatório!"));
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<Produto>(produtoRepository.save(produto),HttpStatus.CREATED );
            }else{
                return new ResponseEntity<Produto>(produtoRepository.save(produto),HttpStatus.OK );
            }

        }
    }

    //Método para remover produtos
    public ResponseEntity<Resposta>remover(Long codigo){
        produtoRepository.deleteById(codigo);
        resposta.setMensagem("O produto foi removido com sucesso!");
        return new ResponseEntity<Resposta>(resposta, HttpStatus.OK);
    }

}
