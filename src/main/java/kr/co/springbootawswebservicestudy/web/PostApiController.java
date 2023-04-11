package kr.co.springbootawswebservicestudy.web;

import kr.co.springbootawswebservicestudy.service.PostService;
import kr.co.springbootawswebservicestudy.web.dtos.request.PostReqDto;
import kr.co.springbootawswebservicestudy.web.dtos.response.PostResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostApiController {

    private final PostService postService;

    @PostMapping
    public Long savePost(@RequestBody PostReqDto.CREATE create){

        return postService.savePost(create);
    }

    @PutMapping("/{id}")
    public Long updatePost(@PathVariable Long id,
                       @RequestBody PostReqDto.UPDATE update) {

        return postService.updatePost(id, update);
    }

    @GetMapping("/{id}")
    public PostResDto.READ findPostById (@PathVariable Long id) {

        return postService.findPostById(id);
    }
}
