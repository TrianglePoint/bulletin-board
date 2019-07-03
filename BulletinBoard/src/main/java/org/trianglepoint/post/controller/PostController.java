package org.trianglepoint.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.trianglepoint.post.domain.PageInfo;
import org.trianglepoint.post.domain.PageListInfo;
import org.trianglepoint.post.domain.PostVO;
import org.trianglepoint.post.service.PostService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/post/*")
@Log4j
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
	 * @param pageInfo : Request number of page from client, search condition
	 */
	@GetMapping({"/get", "/modify"})
	public void get(Long pono, Model model, PageInfo pageInfo) {
		model.addAttribute("post", service.get(pono));
		model.addAttribute("pageInfo", pageInfo);
	}

	/**
	 * @param model : Insert the post data list
	 * @param pageInfo : Request number of page from client, search condition
	 */
	@GetMapping("/list")
	public void list(Model model, PageInfo pageInfo) {
		PageListInfo pageListInfo = new PageListInfo(pageInfo, service.getTotal(pageInfo));
		
		log.info(pageInfo);
		log.info(pageListInfo);
		
		model.addAttribute("list", service.getListPaging(pageInfo));
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("pageListInfo", pageListInfo);
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