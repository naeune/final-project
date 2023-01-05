package himedia.finalproject.repository;

import java.util.List;

import himedia.finalproject.domain.Cluv;

public interface CluvInterfaceRepository {

	Cluv save(Cluv cluv);
	Cluv findById(Long id);
	List<Cluv> findAll();
	Cluv update(Cluv updateCluv);
	void delete(Long id);	
	
}
