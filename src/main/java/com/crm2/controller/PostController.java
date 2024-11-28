package com.crm2.controller;

import com.crm2.entity.Post;
import com.crm2.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
//http://localhost;8080/api/v1/posts
public class PostController {
    private PostRepository postRepository;
    public PostController(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @PostMapping
    public String createPost(@RequestBody Post post){
        postRepository.save(post);
        return "saved";
    }
    @DeleteMapping
    public void deletePost(){
        postRepository.deleteById(1L);
    }
}
