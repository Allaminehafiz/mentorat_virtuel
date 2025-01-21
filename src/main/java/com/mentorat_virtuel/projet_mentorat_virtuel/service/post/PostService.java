package com.mentorat_virtuel.projet_mentorat_virtuel.service.post;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.post.PostReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.post.PostRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Post;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {
    PostRespDTO addPost(PostReqDTO postReqDTO);
    List<Post> getAllPost();
    Page<PostRespDTO> pagination(int offset,int pageSize);
    Post getPostByNom(String nom);
    Post getPostById(Integer postId);
    Post editPostStatus(Integer postId);
    Post updatePost(Post post,Integer postId);
    void deletePost(Integer postId);

    List<Post> addPost(Post post);
}
