package com.mentorat_virtuel.projet_mentorat_virtuel.service.forum;

import com.github.slugify.Slugify;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.forum.ForumReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.forum.ForumResDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Forum;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.User;
import com.mentorat_virtuel.projet_mentorat_virtuel.exception.ResourceExisteException;
import com.mentorat_virtuel.projet_mentorat_virtuel.exception.ResourceNotFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.mapper.ForumMapper;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.ForumRepo;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ForumServiceImpl implements ForumService {
    private final ForumRepo forumRepo;
    private final ForumMapper forumMapper;
    private final UserRepo userRepo;

    public ForumServiceImpl(ForumRepo forumRepo, ForumMapper forumMapper, UserRepo userRepo) {
        this.forumRepo = forumRepo;
        this.forumMapper = forumMapper;
        this.userRepo = userRepo;
    }

    @Override
    public ForumResDTO addForum(ForumReqDTO forumReqDTO) {
        final Slugify slg = Slugify.builder().build();
        Optional<Forum> forumExist = this.forumRepo.findByTitle(forumReqDTO.getTitle());
           if (forumExist.isPresent())
               throw new ResourceExisteException(" Ca existe");
        Forum forum = this.forumMapper.fromForumReqDTO(forumReqDTO);
           forum.setCreatedAt(new Date());
        //forum.setUser(this.userRepo.save(user));
        return this.forumMapper.fromForum(this.forumRepo.save(forum));
    }

    @Override
    public List<Forum> getAllForum() {
        return this.forumRepo.findAll();
    }

    @Override
    public Forum getById(Integer forumId) {
        return this.forumRepo.findById(forumId).get();
    }

    @Override
    public Forum updated(Forum forum, Integer forumId) {
        final Slugify slg = Slugify.builder().build();
        Optional<Forum> forumToEdit = this.forumRepo.findById(forumId);
        if(forumToEdit.isEmpty())
            throw new ResourceNotFoundException("Le nom n'a pas ete trouve");
        if (forum.getTitle() != null){
            forumToEdit.get().setSlug(slg.slugify(forum.getTitle()));
        }
        if (forum.getDescription() != null){
            forumToEdit.get().setDescription(forum.getDescription());
        }
        return this.forumRepo.saveAndFlush(forumToEdit.get());
    }

    @Override
    public void delete(Integer forumId) {
        this.forumRepo.deleteById(forumId);

    }
}