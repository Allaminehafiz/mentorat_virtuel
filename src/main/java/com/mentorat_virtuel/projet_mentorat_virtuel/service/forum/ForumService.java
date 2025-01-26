package com.mentorat_virtuel.projet_mentorat_virtuel.service.forum;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Forum;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Sujet;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ForumService {
    Forum addForum(Forum forum);
    Page<Forum> getForum(int offset, int pageSize);
    List<Forum> getAllForum();
    Forum getForumByDescription(String description);
    Forum getById(Integer forumId);
    Forum updated(Forum forum, Integer forumId);
    void delete(Integer forumId);
    Forum liaison(Integer forumId, Integer sujetId);
}
