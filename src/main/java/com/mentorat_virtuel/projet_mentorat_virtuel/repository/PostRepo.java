package com.mentorat_virtuel.projet_mentorat_virtuel.repository;

import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<Post,Integer> {

    @Query("select p from Post p where p.nom =: nom")
    Optional<Post> findPostByNom(@Param("nom") String nom);
}
