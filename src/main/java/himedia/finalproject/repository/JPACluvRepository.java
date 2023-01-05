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
	public List<Cluv> findAll() {
		log.info("게시글 목록 조회");
		return em.createQuery("select c from Cluv c", Cluv.class).getResultList();
	}

	@Override
	public void delete(Long id) {
		em.remove(findById(id));
	}

	@Override
	public Cluv update(Cluv updateCluv) {
		Cluv cluv = em.find(Cluv.class, updateCluv.getCluvId());
		cluv.setTitle(updateCluv.getTitle());
		cluv.setContents(updateCluv.getContents());
		cluv.setModifiedTime(updateCluv.getModifiedTime());
		return cluv;
	}
	
	
}
