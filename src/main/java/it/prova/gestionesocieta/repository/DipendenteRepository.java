package it.prova.gestionesocieta.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.gestionesocieta.model.Dipendente;

public interface DipendenteRepository extends CrudRepository<Dipendente, Long>, QueryByExampleExecutor<Dipendente> {
	@EntityGraph(attributePaths = {"societa"})
	@Query(value="select distinct d from Dipendente d join d.societa s where s.dataFondazione<'1990-01-01' and d.dataAssunzione in (select min(d.dataAssunzione)from Dipendente d)")
	Dipendente findBySocietaDataAssunzioneBefore() throws Exception;
}
