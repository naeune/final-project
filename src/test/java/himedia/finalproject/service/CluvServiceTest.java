package himedia.finalproject.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import himedia.finalproject.domain.Cluv;

@SpringBootTest
@Transactional
class CluvServiceTest {
	
	@Autowired EntityManager entityManager;
	@Autowired CluvService cluvService;

	@Test
	void write() {
		// given
		Cluv cluv = new Cluv();
		cluv.setContents("테스트");
		
		// when
		Cluv result = cluvService.write(cluv);
		
		// then
		assertThat(result.getContents()).isEqualTo(cluv.getContents());
		
	}
	
	@Test
	void findAllCluv() {
		// given
		List<Cluv> before =  cluvService.findAllCluv();
		Cluv cluv = new Cluv();
		cluvService.write(cluv);
		
		// when
		List<Cluv> after = cluvService.findAllCluv();
		
		// then
		assertThat(after.size()).isEqualTo(before.size() + 1);
	}
	
	@Test
	void findCluvId() {
		// given
		Cluv cluv = new Cluv();
		cluv.setContents("테스트2");
		cluvService.write(cluv);
		
		// when
		Cluv result = cluvService.findCluvId(cluv.getCluvId());
		
		// then
		assertThat(result.getContents()).isEqualTo("테스트2");
	}
	
	@Test
	void searchCluv() {
		// given
		Cluv cluv = new Cluv();
		cluv.setTitle("제목");
		cluvService.write(cluv);
		
		// when
		List<Cluv> result = cluvService.searchCluv(cluv.getTitle());
		
		// then
		assertThat(result).isNotNull();
	}
	
	@Test
	void EditCluv() {
		// given
		Cluv editCluv = new Cluv();
		editCluv.setContents("변경된 테스트3");
		cluvService.write(editCluv);
		Cluv cluv = new Cluv();
		cluv.setContents("테스트3");
		cluvService.write(cluv);
		
		// when
		cluv = cluvService.EditCluv(editCluv);
		cluvService.findCluvId(cluv.getCluvId());
		
		// then
		assertThat(cluv.getContents()).isEqualTo("변경된 테스트3");
	}
	
	@Test
	void deleteCluv() {
		// given
		Cluv cluv = new Cluv();
		cluvService.write(cluv);
		
		// when
		cluvService.deleteCluv(cluv.getCluvId());
		Cluv result = cluvService.findCluvId(cluv.getCluvId());
		
		// then
		assertThat(result).isNull();
	}
	
}
