package com.mentorat_virtuel.projet_mentorat_virtuel.service.user;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Forum;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.ForumRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ForumServiceImpl implements ForumService{
    private final ForumRepo forumRepo;

    public ForumServiceImpl(ForumRepo forumRepo) {
        this.forumRepo = forumRepo;
    }

    @Override
    public Forum addForum(Forum forum) {
        forum.setTitle(forum.getTitle());
        forum.setDescription(forum.getDescription());
        forum.setCreatedBy(new Date());
        forum.setCreatedAt(new Date());
        return this.forumRepo.save(forum);
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
        Forum forumToEdit = this.forumRepo.findById(forumId).get();
        if (forum.getTitle() != null){
            forumToEdit.setTitle(forum.getTitle());
        }
        if (forum.getDescription() != null){
            forumToEdit.setDescription(forum.getDescription());
        }
        return this.forumRepo.saveAndFlush(forumToEdit);
    }

    @Override
    public void delete(Integer forumId) {
        this.forumRepo.deleteById(forumId);

    }
}
