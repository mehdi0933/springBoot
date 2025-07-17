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
    public PostDto.OutputDto getPost(@PathVariable int id) {
        return api.findPostById(id);
    }

    @PostMapping("api")
    public PostDto.OutputDto createPost(@RequestBody PostDto.InputDto postInput) {
        return api.createPost(PostDto.fromInput(postInput));
    }
}

