package br.com.api.produtos_back_end.Repository;

import br.com.api.produtos_back_end.Models.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
