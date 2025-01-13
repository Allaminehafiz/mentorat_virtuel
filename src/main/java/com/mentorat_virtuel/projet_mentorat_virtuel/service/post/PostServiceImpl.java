package com.mentorat_virtuel.projet_mentorat_virtuel.service;

import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Post;
import com.mentorat_virtuel.projet_mentorat_virtuel.exception.RessourceNotFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.repository.PostRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{
    private final PostRepo postRepo;

    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public Post addPost(Post post) {
        return this.postRepo.save(post);
    }

    @Override
    public List<Post> getAllPost() {
        return this.postRepo.findAll();
    }

    @Override
    public Post getPostById(Integer postId) {
        Optional<Post> post = this.postRepo.findById(postId);
        if (post.isEmpty())
            throw new RessourceNotFoundException("post not found!!");
        return post.get();
    }

    @Override
    public Post editPostStatus(Integer postId) {
        Post postToEdit = this.postRepo.findById(postId)
                .orElseThrow(()->new RessourceNotFoundException("post not found!"));
        if(postToEdit.getStatus())
            postToEdit.setStatus(false);
        else
            postToEdit.setStatus(true);
        postToEdit.setDateModification(new Date());
        return this.postRepo.saveAndFlush(postToEdit);
    }

    @Override
    public Post updatePost(Post post, Integer postId) {
        //Rechercher le post
        Optional<Post> postToEdit = this.postRepo.findById(postId);
        if (postToEdit.isEmpty())
            throw new RessourceNotFoundException("post not found");
        // modifier les informations
        if (post.getNom()!=null)
            postToEdit.get().setNom(post.getNom());
        if (post.getContenu()!=null)
            postToEdit.get().setContenu(post.getContenu());
        postToEdit.get().setDateModification(new Date());
        //mettre a jour les nouvelles infos
        return this.postRepo.saveAndFlush(postToEdit.get());

    }

    @Override
    public void deletePost(Integer postId) {
        this.postRepo.delete(this.postRepo.findById(postId)
                .orElseThrow(()-> new RessourceNotFoundException("post not found!!")));
    }
}
