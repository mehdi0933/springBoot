package com.formationspring.demo.RestController;
import com.formationspring.demo.DTO.PostDto;
import com.formationspring.demo.services.Interface.PostInterface;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")

public class PostRestController {

    private final PostInterface api;

    public PostRestController(PostInterface api) {
        this.api = api;
    }

    @GetMapping("api/{id}")
    public PostDto.PostOutputDto getPost(@PathVariable int id) {
        return api.findPostById(id);
    }

    @PostMapping("api")
    public PostDto.PostOutputDto createPost(@RequestBody PostDto.PostInputDto postInput) {
        return api.createPost(PostDto.fromInput(postInput));
    }
}

