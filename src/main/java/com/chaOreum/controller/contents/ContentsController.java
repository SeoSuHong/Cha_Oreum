package com.chaOreum.controller.contents;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contents/")
public class ContentsController {

	@GetMapping("detail")
	public String detail() {
		return "contents.detail";
	}
	
	@GetMapping("reg")
	public String reg() {
		return "contents.reg";
	}
	
	@GetMapping("edit")
	public String edit() {
		return "contents.edit";
	}	
}