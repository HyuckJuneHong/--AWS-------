package kr.co.springbootawswebservicestudy.web.dtos.response;

import lombok.*;

public class PostResDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class READ {

        private Long id;

        private String title;

        private String content;

        private String author;
    }
}
