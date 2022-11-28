package com.kara.socialmedia.controllers;

import com.kara.socialmedia.entities.Post;
import com.kara.socialmedia.requests.PostCreateRequest;
import com.kara.socialmedia.requests.PostUpdateRequest;
import com.kara.socialmedia.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }
    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
        return postService.getAllPosts(userId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest postCreateRequest){
        return postService.createOnePost(postCreateRequest);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){
        return postService.getOnePostById(postId);
    }

    @PutMapping("{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest postUpdateRequest){
        return postService.updateOnePostById(postId, postUpdateRequest);
    }

    @DeleteMapping("{postId}")
    public void deleteOnePost(@PathVariable Long postId){
        postService.deleteById(postId);
    }

}
