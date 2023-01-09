package himedia.finalproject.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import himedia.finalproject.domain.Cluv;

@SpringBootTest
@Transactional
class JPACluvRepositoryTest {
	
	@Autowired JPACluvRepository repository;

	@Test
	void save() {
		// given
		Cluv cluv = new Cluv();
		cluv.setTitle("테스트1");
		
		// when
		Cluv result = repository.save(cluv);
		
		// then
		assertThat(result.getTitle()).isEqualTo("테스트1");
	}
	
	@Test
	void findById() {
		// given
		Cluv cluv = new Cluv();
		cluv.setTitle("테스트2");
		repository.save(cluv);
		
		// when
		Cluv result = repository.findById(cluv.getCluvId());
		
		// then
		assertThat(result.getTitle()).isEqualTo(cluv.getTitle());
	}
	
	@Test
	void findAll() {
		// given
		List<Cluv> before = repository.findAll();
		Cluv cluv = new Cluv();
		repository.save(cluv);
		Cluv cluv2 = new Cluv();
		repository.save(cluv2);
		
		// when
		List<Cluv> after = repository.findAll();
		
		// then
		assertThat(after.size()).isEqualTo(before.size() + 2);
	}
	
	@Test
	void remove() {
		// given
		Cluv cluv = new Cluv();
		repository.save(cluv);
		
		// when
		repository.remove(cluv.getCluvId());
		Cluv result = repository.findById(cluv.getCluvId());
		
		// then
		assertThat(result).isNull();
	}
	
	@Test
	void update() {
		// given
		Cluv updateCluv = new Cluv();
		updateCluv.setTitle("변경 후");
		repository.save(updateCluv);
		Cluv cluv = new Cluv();
		cluv.setTitle("변경 전");
		repository.save(cluv);
		
		
		// when
		cluv = repository.update(updateCluv);
		repository.findByTitle(cluv.getTitle()).get();
		
		// then
		assertThat(cluv.getTitle()).isEqualTo("변경 후");
	}

}
