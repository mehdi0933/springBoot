package com.formationspring.demo.restcontroller;

import com.formationspring.demo.dto.dtoentity.ArticleDto;
import com.formationspring.demo.services.Interface.ArticleInterface;
import org.springframework.web.bind.annotation.*;

import static com.formationspring.demo.mapper.ArticleMapper.fromInput;

@RestController
@RequestMapping("/Post")
public class ArticleRestController {

    private final ArticleInterface postService;

    public ArticleRestController(ArticleInterface postService) {
        this.postService = postService;
    }

    @PostMapping("/")
    public ArticleDto.Output createPost(@RequestBody ArticleDto.Input postInput) {
        return postService.createPost(fromInput(postInput));
    }


    @GetMapping("/{id}")
    public ArticleDto.Output getPost(@PathVariable int id) {
        return postService.findPostById(id);
    }
}


