package com.study.springboot.domain.posts;

import com.study.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//어노테이션 순서는 주요 어노테이션을 클래스에 가깝게 둔다.
@Getter
//클래스 내의 모든 필드의 Getter 메소드 자동생성
@NoArgsConstructor
//기본 생성자 자동추가, public Posts(){}와 같은 효과
@Entity
//테이블과 링크될 클래스임을 나타낸다.
public class Posts extends BaseTimeEntity {
	//Posts 클래스는 실제 DB의 테이블과 매칭될 클래스이며 보통 Entity 클래스라고 함.
	//JPA를 사용하면 DB 데이터에 작업을 할 경우 실제 쿼리를 날리기 보다는 이 클래스를 수정하여 작업한다.

	@Id
	//해당 테이블의 PK필드를 나타냄
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//PK의 생성 규칙을 나타낸다.
	//GenerationType.IDENTITY 옵션을 추가해야 auto increment가 된다
	private Long id;

	@Column(length = 500, nullable = false)
	//테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
	//문자열의 경우 VARCHAR(255)가 기본인데 위와 같이 바꿀수 있다.
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	//타입을 TEXT로 변경한것.
	private String content;

	private String author;

	@Builder
	//해당 클래스의 빌더 패턴 클래스 생성
	//생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함된다.
	public Posts(String title, String content, String author){
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public void update(String title, String content){
		this.title = title;
		this.content = content;
	}
}
//Entity 클래스에는 절대 Setter메소드를 만들지 않는다.
//대신 해당 필드의 값이 변경이 필요하면 명확히 그 목적과 의도를 나타낼수 있는 메소드를 추가해야함.
