package br.edu.infnet.lojadaprata.model.repository;

import br.edu.infnet.lojadaprata.model.domain.Anel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnelRepository extends CrudRepository<Anel, Integer> {
	@Query("from Anel a where a.cadastro.id = :userId")
	List<Anel> listagem(Integer userId);
	List<Anel> findAll(Sort sort);

}
