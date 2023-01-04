package himedia.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/member")
@Controller
public class MemberController {
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String afterLogin() {
		return "redirect:/";
	}
		
	@GetMapping("/join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("/join")
	public String afterJoin() {
		return "redirect:/";
	}
	
	@GetMapping("/find")
	public String find() {
		return "member/find";
	}
	
}
