package com.formationspring.demo.services;

import com.formationspring.demo.entity.ApiEntity;

public interface IApi {

    ApiEntity getPostById(int id);

    ApiEntity createPost(ApiEntity post);
}
