package kr.co.springbootawswebservicestudy.service;

import kr.co.springbootawswebservicestudy.persistence.entity.Post;
import kr.co.springbootawswebservicestudy.persistence.repository.PostRepository;
import kr.co.springbootawswebservicestudy.web.dtos.mappers.PostMapper;
import kr.co.springbootawswebservicestudy.web.dtos.request.PostReqDto;
import kr.co.springbootawswebservicestudy.web.dtos.response.PostResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    private final PostMapper postMapper;

    @Transactional
    public Long savePost(PostReqDto.CREATE create) {

        return postRepository
                .save(postMapper.toPostEntity(create))
                .getId();
    }

    @Transactional
    public Long updatePost(Long id, 
                           PostReqDto.UPDATE update) {

        Post post = postRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        post.updatePost(update.getTitle(), update.getContent());

        return id;
    }

    public PostResDto.READ findPostById(Long id) {

        Post post = postRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return postMapper.toReadDto(post);
    }
}
