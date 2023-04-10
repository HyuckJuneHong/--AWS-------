package kr.co.springbootawswebservicestudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.springbootawswebservicestudy.persistence.BaseTimeEntity;
import lombok.*;

@Getter
@Entity
@Table(name = "tbl_post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    private Post(String title,
                String content,
                String author) {

        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void updatePost(String title, String content) {

        this.title = title;
        this.content = content;
    }
}