package com.crm2.controller;

import com.crm2.entity.Comment;
import com.crm2.entity.Post;
import com.crm2.repository.CommentRepository;
import com.crm2.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")

public class CommentController {
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    public CommentController(CommentRepository commentRepository,PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }
    //http://localhost:8080/api/v1/comments?postId=1
    @PostMapping
    public String createComment(@RequestBody Comment comment, @RequestParam long postId) {

System.out.println("rohit");
System.out.println("koche");
System.out.println(100);


        Post post = postRepository.findById(postId).get();
        // we are getting post object address
        comment.setPost(post);
        commentRepository.save(comment);
        return "Comment create successfully";

    }
}
