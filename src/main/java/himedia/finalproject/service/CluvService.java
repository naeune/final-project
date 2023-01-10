package himedia.finalproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import himedia.finalproject.domain.Cluv;
import himedia.finalproject.repository.JPACluvRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Service
@Builder
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
	
	public List<Cluv> searchCluv(String title) {
		List<Cluv> results = repository.findByTitle(title);
		
		List<Cluv> list = new ArrayList<>();
		
		if(results.isEmpty())
			return list;
		
		for(Cluv cluv: results) {
			list.add(this.convertEntityToDto(cluv));
		}
		
		return list;
	}
	
	private Cluv convertEntityToDto(Cluv cluv) {
		Cluv dto = Cluv.builder()
							.cluvId(cluv.getCluvId())
							.title(cluv.getTitle())
							.contents(cluv.getContents())
							.build();
		return dto;
	}
	
	public Cluv EditCluv(Cluv editCluv) {
		return repository.update(editCluv);
	}
	
	public void deleteCluv(Long id) {
		repository.remove(id);
	}
	
}
