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
	
	/**
	 * @param service
	 */
	@Setter(onMethod_ = @Autowired)
	private PostService service;
	
	/**
	 * Just return : "/post/register"
	 */
	@GetMapping("/register")
	public void register() {

	}
	
	/**
	 * @param post : Post data from client
	 * @param rttr : Insert the Result of register
	 * @return
	 */
	@PostMapping("/register")
	public String register(PostVO post, RedirectAttributes rttr) {
		if(service.register(post)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/post/list";
	}
	
	/**
	 * @param pono : Request number of post from client
	 * @param model : Insert the post data
	 */
	@GetMapping({"/get", "/modify"})
	public void get(Long pono, Model model) {
		model.addAttribute("post", service.get(pono));
	}
	
	/**
	 * @param model : Insert the post data list
	 */
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", service.getList());
	}
	
	/**
	 * @param post : Modified post data from client
	 * @param rttr : Insert the Result of modify
	 * @return
	 */
	@PostMapping("/modify")
	public String modify(PostVO post, RedirectAttributes rttr){
		if(service.modify(post)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/post/list";
	}
	
	/**
	 * @param pono : Request number of post from client
	 * @param rttr : Insert the Result of remove
	 * @return
	 */
	@PostMapping("/remove")
	public String remove(Long pono, RedirectAttributes rttr){
		if(service.remove(pono)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/post/list";
	}
}