package com.formationspring.demo.services.Interface;
import com.formationspring.demo.DTO.PostDto;

public interface PostInterface {

    PostDto.OutputDto findPostById(int id);
    PostDto.OutputDto createPost(PostDto post);

}
