//package com.study.springboot.web;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.Matchers.is;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(SpringExtension.class)
////테스트를 진행할때 JUnit에 내장된 실행자 외에 다른 실행자를 시킴
////여기서 SpringExtention이라는 스프링 실행자를 사용함
////즉 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함
//
//@WebMvcTest(controllers = HelloController.class)
////여러 스프링 부트 테스트 중에서 Web에 집중할수있는 어노테이션
////@Controller, @ControllerAdvice를 사용할수 잇게 해줌
////@Service, Component, Repository 등은 사용할수없음.
//
//public class HelloControllerTest {
//	@Autowired
//	//스프링이 관리하는 빈 을 주입받는다.
//	private MockMvc mvc;
//	//웹 API를 테스트할때 사용
//	//스프링 MVC의 시작점
//	//이 클래스를 통해 HTTP GET POST등에 대한 API테스트 가능
//
//	@Test
//	public void hell가_리턴된다() throws Exception{
//		String hello = "hello";
//		mvc.perform(get("/hello"))
//		//MockMvc를 통해 /hello 주소로 HTTP GET을 요청한다.
//				.andExpect(status().isOk())
//				//mvc.perform의 결과를 검증한다.
//				//HTTP header의 Status를 검증한다.
//				//200,404,500등의 상태를 검증한다.
//				//OK 즉 200인지 아닌지를 검증한다.
//				.andExpect(content().string(hello));
//				//mvc의 결과를 검증한다.
//				//응답 본문의 내용을 검증한다.
//				//Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증한다.
//	}
//	@Test
//	public void helloDto가_리턴된다() throws Exception{
//		String name = "hello";
//		int amount = 1000;
//
//		mvc.perform(get("/hello/dto")
//												.param("name",name)
//												.param("amount",String.valueOf(amount)))
//												//API 테스트할때 사용될 요청 파라미터를 설정
//												//값은 String만 허용된다
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.name",is(name)))
//				//jsonPath 는 JSON 응답값을 필드별로 검증할 수 있는 메소드
//				//$를 기준으로 필드명을 명시
//				//$name과 amount를 검증하니 위 아래와 같이 적어줘야한다.
//				.andExpect(jsonPath("$.amount",is(amount)));
//	}
//}
