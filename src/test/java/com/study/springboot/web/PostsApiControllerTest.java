//package com.study.springboot.web;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.study.springboot.domain.posts.Posts;
//import com.study.springboot.domain.posts.PostsRepository;
//import com.study.springboot.web.dto.PostsSaveRequestDto;
//import java.util.List;
//
//import com.study.springboot.web.dto.PostsUpdateRequestDto;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.*;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class PostsApiControllerTest {
//
//	@LocalServerPort
//	private int port;
//
//	@Autowired
//	private TestRestTemplate restTemplate;
//
//	@Autowired
//	private PostsRepository postsRepository;
//
//	@Autowired
//	private WebApplicationContext context;
//
//	private MockMvc mvc;
//
//	@BeforeEach
//	//매번 테스트가 시작되기 전에 MockMvc 인스턴스를 생성한다.
//	public void setup(){
//		mvc = MockMvcBuilders
//					.webAppContextSetup(context)
//					.apply(springSecurity())
//					.build();
//	}
//
//
//	@AfterEach
//	public void tearDown() throws Exception{
//		postsRepository.deleteAll();
//	}
//
//	@Test
//	@WithMockUser(roles="USER")
//	// 인증된 모의 사용자를 만들어서 사용한다. roles에 권한을 추가할수 있다.
//	// ROLE_USER권한을 가진 사용자가 API를 요청하는 것과 동일한 효과를 가지게 된다.
//	// 하지만 MockMvc에서만 작동하기 때문에 실제로 작동하진 않다.
//	// @SpringBootTest에서 MockMvc를 전혀 사용하고 있지 않기 때문에
//	public void Posts_등록된다() throws Exception{
//		//given
//		String title = "title";
//		String content = "content";
//
//		PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder().
//															title(title)
//															.content(content)
//															.author("author")
//															.build();
//
//		String url = "http://localhost:" + port + "/api/v1/posts";
//
//		//when
//		//생성된 MockMvc를 통해 API를 테스트한다.
//		//본문(Body) 영역은 문자열로 표현하기 위해 ObjectMapper를 통해 문자열을 JSON으로 변환한다.
//		mvc.perform(post(url)
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(new ObjectMapper().writeValueAsString(requestDto)))
//						.andExpect(status().isOk());
//
//		//mvc를 생성하기 전에 사용했던 코드, 로그인 이후 사용불가능하게 되었다.
//		//ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url,requestDto,Long.class);
//
//		//then
//		List<Posts> all = postsRepository.findAll();
//		assertThat(all.get(0).getTitle()).isEqualTo(title);
//		assertThat(all.get(0).getContent()).isEqualTo(content);
//
//		////mvc를 생성하기 전에 사용했던 코드, 로그인 이후 사용불가능하게 되었다.
//		//assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//		//assertThat(responseEntity.getBody()).isGreaterThan(0L);
//	}
//
//	@Test
//	@WithMockUser(roles="USER")
//	public void Posts_수정된다() throws Exception{
//		//given
//		Posts savedPosts = postsRepository.save(Posts.builder()
//				.title("title")
//				.content("content")
//				.author("author")
//				.build());
//
//		Long updateId = savedPosts.getId();
//		String expectedTitle = "title2";
//		String expectedContent = "content2";
//
//		PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
//				.title(expectedTitle)
//				.content(expectedContent)
//				.build();
//
//		String url = "http://localhost:" +port + "/api/v1/posts/"+updateId;
//
//		HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
//
//		//when
//		mvc.perform(post(url)
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(new ObjectMapper().writeValueAsString(requestDto)))
//				.andExpect(status().isOk());
//
//		//mvc를 생성하기 전에 사용했던 코드, 로그인 이후 사용불가능하게 되었다.
//		//ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT,requestEntity,Long.class);
//
//		//then
//		//mvc를 생성하기 전에 사용했던 코드, 로그인 이후 사용불가능하게 되었다.
//		//assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//		//assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//		//then
//		List<Posts> all = postsRepository.findAll();
//		assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
//		assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
//
//	}
//}
