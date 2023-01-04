package himedia.finalproject.repository;

import java.util.List;

import himedia.finalproject.domain.Cluv;

public interface CluvInterfaceRepository {

	Cluv save(Cluv cluv);
	Cluv findById(Long id);
	Cluv findByName(String name);
	List<Cluv> findAll();
	Cluv delete(Cluv cluv);	
	
}
