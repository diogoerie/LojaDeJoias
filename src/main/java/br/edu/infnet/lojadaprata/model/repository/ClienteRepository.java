package br.edu.infnet.lojadaprata.model.repository;

import br.edu.infnet.lojadaprata.model.domain.Anel;
import br.edu.infnet.lojadaprata.model.domain.Cliente;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

	@Query("from Cliente c where c.cadastro.id = :userId")
	List<Cliente> listagem(Integer userId);
	List<Cliente> findAll(Sort sort);
}
