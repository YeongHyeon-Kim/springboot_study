package com.study.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
//JPA Entity 클래스들이 BaseTimeEntity를 상속할경우 필드들도 칼럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class)
//BaseTimeEntity클래스에 Auditing 기능을 포함시킨다.
public abstract class BaseTimeEntity {
	// 모든 Entity의 상위클래스가 되어 Entity들의 createdDate, modifiedDate를 자동으로 관리하는 역할.
	@CreatedDate
	private LocalDateTime createdDate;
	//Entity가 생성되어 저장될때 시간이 자동으로 저장된다.

	@LastModifiedDate
	private LocalDateTime modifiedDate;
	//조회한 Entity의 값을 변경할때 시간이 자동으로 저장된다.
}
