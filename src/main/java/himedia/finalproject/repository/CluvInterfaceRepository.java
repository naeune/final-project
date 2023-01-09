package himedia.finalproject.repository;

import java.util.List;
import java.util.Optional;

import himedia.finalproject.domain.Cluv;

public interface CluvInterfaceRepository {

	Cluv save(Cluv cluv);
	Cluv findById(Long id);
	Optional<Cluv> findByTitle(String title);
	List<Cluv> findAll();
	Cluv update(Cluv updateCluv);
	void remove(Long id);
	
}
