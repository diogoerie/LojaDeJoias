package br.edu.infnet.lojadaprata.model.repository;


import br.edu.infnet.lojadaprata.model.domain.Anel;
import br.edu.infnet.lojadaprata.model.domain.Pulseira;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PulseiraRepository extends CrudRepository<Pulseira, Integer> {
	@Query("from Pulseira p where p.cadastro.id = :userId")
	List<Pulseira> listagem(Integer userId);
	List<Pulseira> findAll(Sort sort);
}
