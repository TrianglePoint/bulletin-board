package org.trianglepoint.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.trianglepoint.post.domain.PostVO;
import org.trianglepoint.post.service.PostService;

import lombok.Setter;

@Controller
@RequestMapping("/post/*")
public class PostController {
	
	@Setter(onMethod_ = @Autowired)
	private PostService service;
	
	@GetMapping("/register")
	public void register() {

	}
	
	@PostMapping("/register")
	public String register(PostVO post, RedirectAttributes rttr) {
		if(service.register(post)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/post/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(Long pono, Model model) {
		model.addAttribute("post", service.get(pono));
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", service.getList());
	}
	
	@PostMapping("/modify")
	public String modify(PostVO post, RedirectAttributes rttr){
		if(service.modify(post)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/post/list";
	}
	
	@PostMapping("/remove")
	public String remove(Long pono, RedirectAttributes rttr){
		if(service.remove(pono)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/post/list";
	}
}