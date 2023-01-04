package himedia.finalproject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.finalproject.domain.Cluv;
import himedia.finalproject.repository.CluvInterfaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/menu/cluv")
@RequiredArgsConstructor
@Controller
@Slf4j
public class CluvController {
	
	private final CluvInterfaceRepository repository;
	
	/**
	 * [게시판 목록 조회] 
	 */
	@GetMapping
	public String cluvs(Model model) {
		List<Cluv> cluvs = repository.findAll();
		model.addAttribute("cluvs", cluvs);
		return "menu/cluv/cluvs";
	}
	
	/**
	 * [상품 상세 페이지] 
	 */
	@GetMapping("/{cluvId}")
	public String cluvPage(@PathVariable Long cluvId, Model model) {
		Cluv cluv = repository.findById(cluvId);
		model.addAttribute("cluv", cluv);
		return "menu/cluv/cluv";
	}
	
	@PostMapping("/add")
	public String addCluv(@ModelAttribute Cluv cluv, RedirectAttributes attributes) {
		Cluv savedCluv = repository.save(cluv);
		log.info("savedCluv id {}", savedCluv.getCluvId());
		log.info("savedCluv title {}", savedCluv.getTitle());
		log.info("savedCluv contents {}", savedCluv.getContents());
		attributes.addAttribute("cluvId", savedCluv.getCluvId());
		return "redirect:/menu/cluv/{cluvId}";
	}

}
