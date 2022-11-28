package com.kara.socialmedia.services;

import com.kara.socialmedia.entities.Post;
import com.kara.socialmedia.entities.User;
import com.kara.socialmedia.repositories.PostRepository;
import com.kara.socialmedia.requests.PostCreateRequest;
import com.kara.socialmedia.requests.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserService userService;

    public PostService(PostRepository postRepository, UserService userService){
        this.postRepository = postRepository;
        this.userService = userService;
    }
    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            return postRepository.findByUserId(userId.get());
        } else {
            return postRepository.findAll();
        }
    }

    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest postCreateRequest) {
        User user = userService.getOneUser(postCreateRequest.getUserId());
        if(user == null){return null;}
        Post toSave = new Post();
        toSave.setId(postCreateRequest.getId());
        toSave.setText(postCreateRequest.getText());
        toSave.setTitle(postCreateRequest.getTitle());
        toSave.setUser(user);
        return postRepository.save(toSave);
    }
    public Post updateOnePostById(Long postId, PostUpdateRequest postUpdateRequest) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            Post toUpdate = post.get();
            toUpdate.setTitle(postUpdateRequest.getTitle());
            toUpdate.setText(postUpdateRequest.getText());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }
    public void deleteById(Long postId) {
        postRepository.deleteById(postId);
    }
}
