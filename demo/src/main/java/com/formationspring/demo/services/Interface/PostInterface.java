package com.formationspring.demo.services.Interface;
import com.formationspring.demo.DTO.PostDto;

public interface PostInterface {

    PostDto.PostOutputDto findPostById(int id);
    PostDto.PostOutputDto createPost(PostDto post);

}
