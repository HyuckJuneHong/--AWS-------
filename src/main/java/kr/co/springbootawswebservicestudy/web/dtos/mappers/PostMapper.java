package kr.co.springbootawswebservicestudy.web.dtos.mappers;

import kr.co.springbootawswebservicestudy.persistence.entity.Post;
import kr.co.springbootawswebservicestudy.web.dtos.request.PostReqDto;
import kr.co.springbootawswebservicestudy.web.dtos.response.PostResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "title", source = "create.title")
    @Mapping(target = "content", source = "create.content")
    @Mapping(target = "author", source = "create.author")
    Post toPostEntity(PostReqDto.CREATE create);


    PostResDto.READ toReadDto(Post post);
}
