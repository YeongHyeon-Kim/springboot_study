package com.study.springboot.domain.user;


import com.study.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column
	private String picture;

	@Enumerated(EnumType.STRING)
	//JPA에 데이터베이스로 저장할때 Enum값을 어던 형태로 저장할지를 결정
	//기본적으로 int로 된 숫자가 저장된다,.
	//숫자로 저장되면 데이터베이스로 확인할때 그 값이 무슨 코드를 의미하는지 알수가없다.
	//그래서 enumType.String으로 저장될수있도록 선언한다.
	@Column(nullable = false)
	private Role role;

	@Builder
	public User(String name, String email, String picture, Role role){
		this.name = name;
		this.email = email;
		this.picture = picture;
		this.role = role;
	}

	public User  update(String name, String picture){
		this.name = name;
		this.picture = picture;
		return  this;
	}
	public String getRoleKey(){
		return this.role.getKey();
	}
}
