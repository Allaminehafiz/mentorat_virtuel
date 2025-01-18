package com.mentorat_virtuel.projet_mentorat_virtuel.controller;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.post.PostReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.post.PostRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Post;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.post.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping(path = "post/add")
    @ResponseBody
    public ResponseEntity<PostRespDTO> addPost(@Valid @RequestBody PostReqDTO postReqDTO){
        PostRespDTO postRespDTO = this.postService.addPost(postReqDTO);
        return new ResponseEntity<>(postRespDTO,HttpStatus.CREATED);

    }
    @GetMapping(path = "post/get_all-post")
    public ResponseEntity<List<Post>> getAllPost(){
        return ResponseEntity
                .ok(this.postService.getAllPost());
    }
    @GetMapping(path = "post/get_post_by_id/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer postId){
        return ResponseEntity
                .status(200)
                .body(this.postService.getPostById(postId));
    }
    @PutMapping(path = "post/editStatus/{postId}")
    public ResponseEntity<Post> disablePost(Integer postId){
        return ResponseEntity
                .status(202)
                .body(this.postService.editPostStatus(postId));
    }
    @PutMapping(path = "post/update_post_by_id/{postId}")
    public ResponseEntity<Post> updatePost(@Valid @RequestBody Post post,@PathVariable Integer postId){
        return ResponseEntity
                .status(202)
                .body(this.postService.updatePost(post, postId));
    }
    @DeleteMapping(path = "post/delete_post_by_id/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return ResponseEntity
                .status(202)
                .body("your post deleted successfully!!");
    }
}
