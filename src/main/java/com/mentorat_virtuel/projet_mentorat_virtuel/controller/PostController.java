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
            summary = "Récupérer une page de posts",
            description = "Cette méthode permet de récupérer une page de posts avec une pagination en fonction des paramètres d'offset et de taille de page."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Page de posts récupérée avec succès."),
            @ApiResponse(responseCode = "400", description = "Les paramètres de pagination sont invalides.")
    })
    @GetMapping(path = "post/pagination/{offset}/{pageSize}")
    public ResponseEntity<Page<PostRespDTO>> pagination(@PathVariable int offset,@PathVariable int pageSize){
        return ResponseEntity
                .ok(this.postService.pagination(offset, pageSize));
    }
    @Operation(
            summary = "Récupérer un post par son identifiant",
            description = "Cette méthode permet de récupérer un post spécifique en utilisant son identifiant unique dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le post a été récupéré avec succès."),
            @ApiResponse(responseCode = "404", description = "Post non trouvé pour l'ID donné.")
    })
    @GetMapping(path = "post/get_post_by_id/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer postId){
        return ResponseEntity
                .status(200)
                .body(this.postService.getPostById(postId));
    }
    @Operation(
            summary = "Récupérer un post par son nom",
            description = "Cette méthode permet de récupérer un post spécifique en utilisant son nom dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le post a été récupéré avec succès."),
            @ApiResponse(responseCode = "404", description = "Post non trouvé pour le nom donné.")
    })
    @GetMapping(path = "post/get-by-nom/{nom}")
    public ResponseEntity<Post> getPostByNom(@PathVariable String nom){
        return ResponseEntity
                .ok(this.postService.getPostByNom(nom));
    }
    @PutMapping(path = "post/editStatus/{postId}")
    public ResponseEntity<Post> disablePost(Integer postId){
        return ResponseEntity
                .status(202)
                .body(this.postService.editPostStatus(postId));
    }
    @Operation(
            summary = "Mettre à jour l'état d'un post",
            description = "Cette méthode permet de mettre à jour l'état (par exemple, actif/inactif) d'un post existant dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "L'état du post a été mis à jour avec succès."),
            @ApiResponse(responseCode = "404", description = "Post non trouvé pour l'ID donné.")
    })
    @PutMapping(path = "post/update_post_by_id/{postId}")
    public ResponseEntity<Post> updatePost(@Valid @RequestBody Post post,@PathVariable Integer postId){
        return ResponseEntity
                .status(200)
                .body(this.postService.updatePost(post, postId));
    }
    @Operation(
            summary = "Supprimer un post par son identifiant",
            description = "Cette méthode permet de supprimer un post de la base de données en utilisant son identifiant unique."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le post a été supprimé avec succès de la base de données."),
            @ApiResponse(responseCode = "404", description = "Post non trouvé pour l'ID donné.")
    })
    @DeleteMapping(path = "post/delete_post_by_id/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return ResponseEntity
                .status(200)
                .body("your post deleted successfully!!");
    }
}
