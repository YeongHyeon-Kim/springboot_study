package com.study.springboot.web.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
	@Test
	public void 롬복_기능_테스트(){
		//given
		String name = "test";
		int amount = 1000;

		//when
		HelloResponseDto dto = new HelloResponseDto(name,amount);

		//then
		assertThat(dto.getName()).isEqualTo(name);
		//assertj라는 테스트 검증 라이브러리의 검증 메소드
		//검증하고 싶은 대상을 메소드 인자로 받는다.
		//메소드 체이닝이 지원되어 isEqualto와 같이 메소드를 이어서 사용할수 있다.

		//isEqualTo는 assertj에 있는 동등비교 메소드이다.
		//assertThat에 잇는 값과 isEqulTo의 값을 비교해서 같을때만 성공이다.
		assertThat(dto.getAmount()).isEqualTo(amount);
	}

}
