package com.study.springboot.web;

import com.study.springboot.service.PostsService;
import com.study.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

	private final PostsService postsService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("posts",postsService.findAllDesc());
		return "index";
	}

	@GetMapping("/posts/save")
	public String postsSave() {
		return "posts-save";
//		리턴되는 값 이름의 머스태치 파일을 불러옴
	}

	@GetMapping("/posts/update/{id}")
	public String postsUpdate(@PathVariable Long id, Model model){
		PostsResponseDto dto = postsService.findById(id);
		model.addAttribute("post",dto);
		return "posts-update";
	}
}
