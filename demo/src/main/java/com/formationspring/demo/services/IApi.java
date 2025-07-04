package com.formationspring.demo.services;

public interface IApi {

    <Post> Post getPostById(int id);
    <Post> Post createPost(Post post);
}
