package com.mentorat_virtuel.projet_mentorat_virtuel.service.user;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Forum;

import java.util.List;

public interface ForumService {
    Forum addForum(Forum forum);
    List<Forum> getAllForum();
    Forum getById(Integer forumId);
    Forum updated(Forum forum, Integer forumId);
    void delete(Integer forumId);

}
