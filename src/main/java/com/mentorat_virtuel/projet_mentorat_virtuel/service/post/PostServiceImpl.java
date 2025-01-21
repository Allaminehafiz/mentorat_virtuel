package com.mentorat_virtuel.projet_mentorat_virtuel.service.post;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.post.PostReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.post.PostRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Post;
import com.mentorat_virtuel.projet_mentorat_virtuel.exception.RessourceNotFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.mapper.PostMapper;
import com.mentorat_virtuel.projet_mentorat_virtuel.repository.PostRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;
    private final PostMapper postMapper;

    public PostServiceImpl(PostRepo postRepo, PostMapper postMapper) {
        this.postRepo = postRepo;
        this.postMapper = postMapper;
    }

    @Override
    public PostRespDTO addPost(PostReqDTO postReqDTO) {
        Post post = this.postMapper.fromPostReqDTO(postReqDTO);

        post = this.postRepo.save(post);
        return postMapper.fromPost(post);
    }

    @Override
    public List<Post> getAllPost() {

        return this.postRepo.findAll();
    }

    @Override
    public Page<PostRespDTO> pagination(int offset, int pageSize) {
        return this.postRepo.findAll(PageRequest.of(offset, pageSize,Sort.by(Sort.Direction.DESC,"dateCreation")))
                .map(post -> this.postMapper.fromPost(post));
    }

    @Override
    public Post getPostByNom(String nom) {
        Optional<Post> post = this.postRepo.findPostByNom(nom);
        if (post.isEmpty())
            throw new RessourceNotFoundException("Post not found!!");
        return post.get();
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
