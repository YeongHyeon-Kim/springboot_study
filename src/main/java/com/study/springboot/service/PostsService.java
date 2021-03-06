package com.study.springboot.service;


import com.study.springboot.domain.posts.Posts;
import com.study.springboot.domain.posts.PostsRepository;
import com.study.springboot.web.dto.PostsListResponseDto;
import com.study.springboot.web.dto.PostsResponseDto;
import com.study.springboot.web.dto.PostsSaveRequestDto;

import com.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
	private final PostsRepository postsRepository;

	@Transactional
	public Long save(PostsSaveRequestDto requestsDto ){
		return postsRepository.save(requestsDto.toEntity()).getId();
	}

	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto){
		Posts posts = postsRepository.findById(id).orElseThrow(()->
				new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

		posts.update(requestDto.getTitle(),requestDto.getContent());
		return id;
	}

	public PostsResponseDto findById(Long id){
		Posts entity = postsRepository.findById(id).orElseThrow(()->
				new IllegalArgumentException("해당 게시글이 없습니다 id="+id));
		return new PostsResponseDto(entity);
	}

	@Transactional(readOnly = true)
	//readOnly = true를 추가하면 트랜잭션 범위는 유지하되 조회 기능만 남겨두어 죄회 속도가 개선된다.
	//등록,수정,삭제 기능이 전혀 없는 서비스 메소드에서 사용하는 것을 추천한다.
	public List<PostsListResponseDto> findAllDesc(){
		return postsRepository.findAllDesc().stream()
				.map(PostsListResponseDto::new)
				//.map(posts-> new PostsListResponseDto(posts))와 같다.
				.collect(Collectors.toList());
	}

	@Transactional
	public void delete(Long id){
		Posts posts = postsRepository.findById(id).orElseThrow(()->
							new IllegalArgumentException("해당 게시글이 없습니다. id = "+ id));
		postsRepository.delete(posts);
	}
}
