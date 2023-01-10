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
public class JPACluvRepository {

	private final EntityManager em;

	public Cluv save(Cluv cluv) {
		log.info("게시글 저장");
		em.persist(cluv);
		return cluv;
	}

	public Cluv findById(Long id) {
		return em.find(Cluv.class, id);
	}

	public List<Cluv> findByTitle(String title) {
		List<Cluv> result = em.createQuery("select c from Cluv c where c.title like :title", Cluv.class)
								.setParameter("title", "%"+title+"%")
								.getResultList();
		return result;
	}

	public List<Cluv> findAll() {
		log.info("게시글 목록 조회");
		return em.createQuery("select c from Cluv c", Cluv.class).getResultList();
	}

	public void remove(Long id) {
		em.remove(findById(id));
	}

	public Cluv update(Cluv updateCluv) {
		Cluv cluv = em.find(Cluv.class, updateCluv.getCluvId());
		cluv.setTitle(updateCluv.getTitle());
		cluv.setContents(updateCluv.getContents());
		cluv.setModifiedTime(updateCluv.getModifiedTime());
		return cluv;
	}

}