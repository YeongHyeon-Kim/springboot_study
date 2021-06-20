package com.study.springboot.config.auth;

import com.study.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
	//Serializable 직렬화 한다는 의미
	//우리가 만든 클래스가 파일에 쓸수있거나 다른 서버로 보내거나 받을 수 있또록 하려면 이 인터페이스를 구현해야함.
	//User 클래스는 엔티티이기 때문에 언제 다른 엔티티와 관계가 형성 될지 모른다
	//그래서 자식 엔티티까지 직렬화가 될수도 있으니 성능이슈, 부수효과가 발생할 확률이 높아서 따로 만드는게 유지보수에 좋다.
	private String name;
	private String email;
	private String picture;

	public SessionUser(User user){
		this.name = user.getName();
		this.email = user.getEmail();
		this.picture = user.getPicture();
	}
	// 인증된 사용자 정보만 필요하다. 그 외에 필요한 정보는 없다.
}
