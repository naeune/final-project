package himedia.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/menu")
@Controller
public class CategoryController {
	
	@GetMapping("/about")
	public String about() {
		return "menu/about/introduce";
	}
	
	@GetMapping("/category")
	public String category() {
		return "menu/category/category";
	}
	
	@GetMapping("/category/outfit")
	public String outfit() {
		return "menu/category/outfit";
	}
	
	@GetMapping("/category/beauty")
	public String beauty() {
		return "menu/category/beauty";
	}
	
	@GetMapping("/category/things")
	public String things() {
		return "menu/category/things";
	}
	
	@GetMapping("/cluv")
	public String cluv() {
		return "menu/cluv/cluv";
	}

}
