package himedia.finalproject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.finalproject.domain.Cluv;
import himedia.finalproject.service.CluvService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/menu/cluv")
@RequiredArgsConstructor
@Controller
@Slf4j
public class CluvController {
	
	private final CluvService service;
	
	/**
	 * [게시판 목록 조회] 
	 */
	@GetMapping
	public String cluvs(Model model) {
		List<Cluv> cluvs = service.findAllCluv();
		model.addAttribute("cluvs", cluvs);
		return "menu/cluv/cluvs";
	}
	
	/**
	 * [상품 상세 페이지] 
	 */
	@GetMapping("/{cluvId}")
	public String cluvPage(@PathVariable Long cluvId, Model model) {
		Cluv cluv = service.findCluvId(cluvId);
		model.addAttribute("cluv", cluv);
		return "menu/cluv/cluv";
	}
	
	@PostMapping("/add")
	public String addCluv(@ModelAttribute Cluv cluv, RedirectAttributes attributes) {
		Cluv savedCluv = service.write(cluv);
		log.info("savedCluv id {}", savedCluv.getCluvId());
		log.info("savedCluv title {}", savedCluv.getTitle());
		log.info("savedCluv contents {}", savedCluv.getContents());
		attributes.addAttribute("cluvId", savedCluv.getCluvId());
		return "redirect:/menu/cluv/{cluvId}";
	}
	
	@GetMapping("delete/{cluvId}")
	public String deleteCluv(@PathVariable Long cluvId) {
		service.deleteCluv(cluvId);
		return "redirect:/menu/cluv";
	}
	
	@GetMapping("/edit/{cluvId}")
	public String editCluv(@PathVariable Long cluvId, Model model) {
		Cluv cluv = service.findCluvId(cluvId);
		model.addAttribute("cluv", cluv);
		return "menu/cluv/cluvEdit";
	}
	
	@PostMapping("/edit/{cluvId}")
	public String updateCluv(@PathVariable Long cluvId, @ModelAttribute Cluv cluv) {
		service.EditCluv(cluv);
		return "redirect:/menu/cluv/{cluvId}";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam(value="title", required=false) String title, Model model) {
		List<Cluv> searchLists = service.searchCluv(title);
		model.addAttribute("searchLists", searchLists);
		return "menu/cluv/resultPage";
	}

}
