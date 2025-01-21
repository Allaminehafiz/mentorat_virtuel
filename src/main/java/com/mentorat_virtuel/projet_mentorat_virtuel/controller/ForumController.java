package com.mentorat_virtuel.projet_mentorat_virtuel.controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.dto.forum.ForumReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.forum.ForumResDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Forum;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.forum.ForumService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ForumController {
    private final ForumService forumService;

    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }
    @PostMapping(path = "forum/add")
    ResponseEntity<ForumResDTO> addForum(@Valid @RequestBody ForumReqDTO forumReqDTO){
        return ResponseEntity.status(201).body(this.forumService.addForum(forumReqDTO));
    }
    @GetMapping(path = "forum/getALL")
    public ResponseEntity<List<Forum>> getAllForum(){
       return ResponseEntity.status(200).body(this.forumService.getAllForum());
    }
    @GetMapping(path = "forum/getbyId{forumId}")
    public ResponseEntity<Forum> getbyId(@PathVariable Integer forumId){
        return ResponseEntity.status(200).body(this.forumService.getById(forumId));
    }
    @PutMapping(path = "forum/updated{forumId}")
    public ResponseEntity<Forum> updatedForum(@RequestBody Forum forum, @PathVariable Integer forumId){
        return ResponseEntity.status(200).body(this.forumService.updated(forum, forumId));
    }
    @DeleteMapping(path = "forum/delete{forumId}")
    public ResponseEntity<String> deleteForum(@PathVariable Integer forumId){
        this.forumService.delete(forumId);
        return ResponseEntity.status(202).body("Delete successfully");
    }


}
