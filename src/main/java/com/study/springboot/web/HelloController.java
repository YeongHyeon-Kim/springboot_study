package com.study.springboot.web;

import com.study.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌
public class HelloController {
	@GetMapping("/hello")
	//HTTP Method인 Get요청을 받을수 있는 API를 만들어준다.
	// /hello로 요청의 들어오면 Hello를 반환하는 기능을 가지게 된다.
	public String hello(){
		return "hello";
	}

	@GetMapping("/hello/dto")
	public HelloResponseDto helloDto(@RequestParam("name") String name,
	                                 @RequestParam("amount")int amount){
		//외부에서 API로 넘긴 파라미터를 가져옴
		//"name"이란 이름으로 넘긴 파라미터를 메소드 파라미터 String name에 저장하게 된다.
		return new HelloResponseDto(name, amount);
	}


}
