package himedia.finalproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import himedia.finalproject.domain.Cluv;
import himedia.finalproject.repository.JPACluvRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CluvService {
	
	private final JPACluvRepository repository;
	
	public Cluv write(Cluv cluv) {
		return repository.save(cluv);
	}
	
	public List<Cluv> findAllCluv() {
		return repository.findAll();
	}
	
	public Cluv findCluvId(Long id) {
		return repository.findById(id);
	}
	
	public Cluv EditCluv(Cluv editCluv) {
		return repository.update(editCluv);
	}
	
	public void deleteCluv(Long id) {
		repository.remove(id);
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}
}
