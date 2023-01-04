package himedia.finalproject.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import himedia.finalproject.domain.Cluv;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Transactional
@Slf4j
public class JPACluvRepository implements CluvInterfaceRepository {

	private final EntityManager em;

	@Override
	public Cluv save(Cluv cluv) {
		log.info("게시글 저장");
		em.persist(cluv);
		return cluv;
	}

	@Override
	public Cluv findById(Long id) {
		return em.find(Cluv.class, id);
	}

	@Override
	public Cluv findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cluv> findAll() {
		log.info("게시글 목록 조회");
		return em.createQuery("select c from Cluv c", Cluv.class).getResultList();
	}

	@Override
	public Cluv delete(Cluv cluv) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
