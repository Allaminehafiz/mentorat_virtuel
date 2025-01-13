package com.mentorat_virtuel.projet_mentorat_virtuel.service;

import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Post;

import java.util.List;

public interface PostService {
    Post addPost(Post post);
    List<Post> getAllPost();
    Post getPostById(Integer postId);
    Post editPostStatus(Integer postId);
    Post updatePost(Post post,Integer postId);
    void deletePost(Integer postId);
}
