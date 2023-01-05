package himedia.finalproject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import himedia.finalproject.domain.Cluv;

@SpringBootTest
@Transactional
class JPACluvRepositoryTest {

	@Test
	void save() {
		// given
		Cluv cluv = new Cluv();
		cluv.setTitle("테스트입니다");
		
		// when
		
		// then
	}

}
