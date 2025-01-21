package com.mentorat_virtuel.projet_mentorat_virtuel.mapper;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire.CommentaireReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.post.PostReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.post.PostRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Commentaire;
import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Post;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
@Configuration
public interface PostMapper {
    Post fromPostReqDTO(PostReqDTO postReqDTO);
    Commentaire fromCommentaireReqDTO(CommentaireReqDTO commentaireReqDTO);
    PostRespDTO fromPost(Post post);
}
