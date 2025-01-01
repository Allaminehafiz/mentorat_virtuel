package com.mentorat_virtuel.projet_mentorat_virtuel.service.user;

import com.github.slugify.Slugify;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Forum;
import com.mentorat_virtuel.projet_mentorat_virtuel.exception.RessourceExistException;
import com.mentorat_virtuel.projet_mentorat_virtuel.exception.RessourceNotFoundException;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.ForumRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ForumServiceImpl implements ForumService{
    private final ForumRepo forumRepo;

    public ForumServiceImpl(ForumRepo forumRepo) {
        this.forumRepo = forumRepo;
    }

    @Override
    public Forum addForum(Forum forum) {
        final Slugify slg = Slugify.builder().build();
        Optional<Forum> forumExist = this.forumRepo.findByTitle(forum.getTitle());
        if(forumExist.isPresent())
            throw new RessourceExistException("Le titre existe");
        forum.setSlug(slg.slugify(forum.getTitle()));
        forum.setDescription(forum.getDescription());
        forum.setCreatedBy(forum.getCreatedBy());
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
        final Slugify slg = Slugify.builder().build();
        Optional<Forum> forumToEdit = this.forumRepo.findById(forumId);
        if(forumToEdit.isEmpty())
            throw new RessourceNotFoundException("Le nom n'a pas ete trouve");
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
