package br.edu.infnet.lojadaprata.model.repository;

import br.edu.infnet.lojadaprata.model.domain.Anel;
import br.edu.infnet.lojadaprata.model.domain.Colar;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColarRepository extends CrudRepository<Colar, Integer> {
	@Query("from Colar c where c.cadastro.id = :userId")
	List<Colar> listagem(Integer userId);
	List<Colar> findAll(Sort sort);
}
