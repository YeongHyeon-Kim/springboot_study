package com.study.springboot.domain.posts;


import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;

	@AfterEach
	//Junit에서 단위 테스트가 끝날때마다 수행되는 메소드를 지정
	//보통은 배포 전 전체 테스트를 수행할때 테스트간 데이터침범을 막기 위해 사용한다.
	//여러 테스트가 동시에 수행되면 테스트용 데이터베이스인 H2에 데이터가 그대로 남아있어 다음 테스트 실행시 실패할수도 있다.
	public void cleanup(){
		postsRepository.deleteAll();
	}

	@Test
	public void 게시글저장_불러오기(){
		//given
		String title = "테스트 게시글";
		String content = "테스트 본문";

		//.save 테이블 Posts에 insert/update쿼리를 실행한다.
		//id 값이 있다면 update, 없다면 insert가 실행된다.
		postsRepository.save(Posts.builder()
											.title(title)
											.content(content)
											.author("KimYH")
											.build());


		//when
		List<Posts> postsList = postsRepository.findAll();
		//테이블에 있는 모든 데이터를 조회하는 메소드이다.

		Posts posts = postsList.get(0);
		assertThat(posts.getTitle()).isEqualTo(title);
		assertThat(posts.getContent()).isEqualTo(content);

	}

	@Test
	public void BaseTimeEntity_등록() throws Exception{
		//given
		LocalDateTime now = LocalDateTime.of(2021,6,8,0,0,0);
		postsRepository.save(Posts.builder()
							.title("title")
							.content("content")
							.author("author123")
							.build());

		//when
		List<Posts> postsList = postsRepository.findAll();

		//then
		Posts posts = postsList.get(0);
		System.out.println(posts.getAuthor());
		System.out.println(">>>>>>>>>>>>>> createDate="+posts.getCreatedDate()+", modifiedDate="+
				posts.getModifiedDate());

		assertThat(posts.getCreatedDate()).isAfter(now);
		assertThat(posts.getModifiedDate()).isAfter(now);

	}

}
