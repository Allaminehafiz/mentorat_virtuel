package com.mentorat_virtuel.projet_mentorat_virtuel.service.forum;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.forum.ForumReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.forum.ForumResDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Forum;

import java.util.List;

public interface ForumService {
    ForumResDTO addForum(ForumReqDTO forumReqDTO);
    List<Forum> getAllForum();
    Forum getById(Integer forumId);
    Forum updated(Forum forum, Integer forumId);
    void delete(Integer forumId);

}
