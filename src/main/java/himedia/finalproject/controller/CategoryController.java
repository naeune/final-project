package himedia.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/menu")
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
	
	@GetMapping("/cloes")
	public String cloes() {
		return "menu/cloes/cloes";
	}
	
	@GetMapping("/mypage")
	public String mypage() {
		return "menu/mypage/mypage";
	}
	
	@GetMapping("/mypage/mycloset")
	public String mycloset() {
		return "menu/mypage/mycloset";
	}
	
	@GetMapping("/mypage/mycluvs")
	public String mycluvs() {
		return "menu/mypage/mycluvs";
	}
	
	@GetMapping("/mypage/follow")
	public String follow() {
		return "menu/mypage/follow";
	}
	
	@GetMapping("/mypage/setting")
	public String setting() {
		return "menu/mypage/setting";
	}
	
	@GetMapping("/cluv/write")
	public String cluvWrite() {
		return "menu/cluv/cluvWrite";
	}
	
	@PostMapping("/cluv/write")
	public String afterWrite() {
		return "redirect:/menu/cluv";
	}

}
