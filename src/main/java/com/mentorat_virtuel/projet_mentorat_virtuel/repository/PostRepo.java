package com.mentorat_virtuel.projet_mentorat_virtuel.repository;

import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post,Integer> {
}
