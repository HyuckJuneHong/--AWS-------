package kr.co.springbootawswebservicestudy.persistence.post;

import kr.co.springbootawswebservicestudy.persistence.entity.Post;
import kr.co.springbootawswebservicestudy.persistence.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @AfterEach
    public void cleanUp(){
        postRepository.deleteAll();
    }

    @Test
    public void save_and_load_post(){

        //given
        String title = "Test Title";
        String content = "Test Content";
        final Post post = Post.builder()
                .title(title)
                .content(content)
                .author("example@naver.com")
                .build();
        postRepository.save(post);

        //when
        List<Post> posts = postRepository.findAll();

        //then
        Post postThen = posts.get(0);
        assertThat(postThen.getTitle()).isEqualTo(title);
        assertThat(postThen.getContent()).isEqualTo(content);
    }

    @Test
    public void baseTimeEntity_Create(){

        // given
        LocalDate now = LocalDate.of(2023, 1, 22);
        postRepository.save(Post.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        // when
        List<Post> postsList = postRepository.findAll();

        // then
        Post posts = postsList.get(0);
        System.out.println(">>>>>>>>> createDate=" + posts.getCreateAt() + ", modifiedDate=" + posts.getModifiedAt());
        assertThat(posts.getCreateAt()).isAfter(now);
        assertThat(posts.getModifiedAt()).isAfter(now);
    }
}