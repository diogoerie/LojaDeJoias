package br.edu.infnet.lojadaprata.model.repository;

import br.edu.infnet.lojadaprata.model.domain.Anel;
import br.edu.infnet.lojadaprata.model.domain.Pedido;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

	@Query("from Pedido p where p.cadastro.id = :userId")
	List<Pedido> obterLista(Integer userId);

}
