package com.study.springboot.domain.posts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//Posts 클래스로 Database를 접근하게 해줄 DB Layer 접근자.
//인터페이스 생성후 <Entity 클래스, pk타입>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.
public interface PostsRepository extends JpaRepository<Posts,Long> {
	//@Repository를 추가할 필요도 없다.
	//다만 Entity 클래스와 기본 Entity Repository는 함께 위치해야한다.

	@Query("SELECT p from Posts p ORDER BY p.id DESC")
	List<Posts> findAllDesc();
}
