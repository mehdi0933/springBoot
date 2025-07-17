package com.formationspring.demo.RestController;
import com.formationspring.demo.DTO.PostDto;
import com.formationspring.demo.services.Interface.PostInterface;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")

public class PostRestController {

    private final PostInterface Post;

    public PostRestController(PostInterface Post) {
        this.Post = Post;
    }

    @GetMapping("Post/{id}")
    public PostDto.OutputDto getPost(@PathVariable int id) {
        return Post.findPostById(id);
    }

    @PostMapping("Post")
    public PostDto.OutputDto createPost(@RequestBody PostDto.InputDto postInput) {
        return Post.createPost(PostDto.fromInput(postInput));
    }
}

