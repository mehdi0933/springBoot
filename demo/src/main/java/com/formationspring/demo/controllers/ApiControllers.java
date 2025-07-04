package com.formationspring.demo.controllers;
import com.formationspring.demo.entity.ApiEntity;
import com.formationspring.demo.services.IApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class ApiControllers {
    private final IApi api;

public ApiControllers( IApi api) {
        this.api = api;
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<ApiEntity> getPos(@PathVariable int id) {
        ApiEntity post = api.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @PostMapping("/api")
    public ResponseEntity<ApiEntity> createPost(@RequestBody ApiEntity post) {
        ApiEntity created = api.createPost(post);
        return ResponseEntity.ok(created);
    }


}
