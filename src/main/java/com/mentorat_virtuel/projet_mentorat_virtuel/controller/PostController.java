package com.mentorat_virtuel.projet_mentorat_virtuel.controller;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.post.PostReqDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.dto.post.PostRespDTO;
import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Post;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.post.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @Operation(
            summary = "Ajouter un nouveau Post",
            description = "Cette méthode permet d'ajouter un nouveau post dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Post ajoutée avec succès"),
            @ApiResponse(responseCode = "400", description = "Les données envoyées sont invalides")
    })
    @PostMapping(path = "post/add")
    @ResponseBody
    public ResponseEntity<PostRespDTO> addPost(@Valid @RequestBody PostReqDTO postReqDTO){
        PostRespDTO postRespDTO = this.postService.addPost(postReqDTO);
        return new ResponseEntity<>(postRespDTO,HttpStatus.CREATED);

    }
    @Operation(
            summary = "Affiche tout les posts",
            description = "Cette méthode permet d'ajouter tout les posts present dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Affiche tout les Posts")})
    @GetMapping("/post/get-all-post/")
    public ResponseEntity<List<Post>> getAllPost(){
        return ResponseEntity
                .ok(this.postService.getAllPost());
    }
    @Operation(
            summary = "Affiche une page Post ",
            description = "Cette méthode permet d'afficher une page de post."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Affiche une paage de post")})
    @GetMapping(path = "post/pagination/{offset}/{pageSize}")
    public ResponseEntity<Page<PostRespDTO>> pagination(@PathVariable int offset,@PathVariable int pageSize){
        return ResponseEntity
                .ok(this.postService.pagination(offset, pageSize));
    }

    @Operation(
            summary = "Affiche un Post grace a son ID",
            description = "Cette méthode permet d'afficher un post grace a son ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Affiche un post grace a l'ID")})
    @GetMapping(path = "post/get_post_by_id/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer postId){
        return ResponseEntity
                .status(200)
                .body(this.postService.getPostById(postId));
    }
    @PutMapping(path = "post/editStatus/{postId}")
    public ResponseEntity<Post> disablePost(Integer postId){
        return ResponseEntity
                .status(202)
                .body(this.postService.editPostStatus(postId));
    }
    @Operation(
            summary = "Mise A Jour d'un Post",
            description = "Cette méthode permet de faire la mise a jour d'un post dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le Post a bien ete mis a jour"),
            @ApiResponse(responseCode = "400", description = "Les données envoyées sont invalides")
    })
    @PutMapping(path = "post/update_post_by_id/{postId}")
    public ResponseEntity<Post> updatePost(@Valid @RequestBody Post post,@PathVariable Integer postId){
        return ResponseEntity
                .status(200)
                .body(this.postService.updatePost(post, postId));
    }
    @Operation(
            summary = "Supprimer un Post Grace a son ID",
            description = "Cette méthode permet de supprimer un post grace a son ID dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post supprime de la base de donnees")})
    @DeleteMapping(path = "post/delete_post_by_id/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return ResponseEntity
                .status(200)
                .body("your post deleted successfully!!");
    }
}
