package com.mentorat_virtuel.projet_mentorat_virtuel.controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Image;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.image.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }
    @Operation(
            summary = "permet de faire le telechargement d'ine image",
            description = "Cette méthode permet d'ajouter un nouveau fichier  dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "fichier ajoutée avec succès"),
            @ApiResponse(responseCode = "400", description = "Les données envoyées sont invalides")
    })
    @PostMapping("image/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            imageService.storeImage(file);
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }
    @Operation(
            summary = "Récupérer un image par son identifiant",
            description = "Cette méthode permet de récupérer un image spécifique en utilisant son identifiant unique dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'image a été récupéré avec succès."),
            @ApiResponse(responseCode = "404", description = "image non trouvé pour l'ID donné.")
    })
    @GetMapping("image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Integer id) {
        Image image = imageService.getImageById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getType()))
                .body(new byte[]{image.getContent()});
    }
    @Operation(
            summary = "Récupérer une image par son nom",
            description = "Cette méthode permet de récupérer une image spécifique en utilisant son nom dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'image a été récupéré avec succès."),
            @ApiResponse(responseCode = "404", description = "l'image non trouvé pour le nom donné.")
    })
    @GetMapping("image/{name}")
    public ResponseEntity<byte[]> getImageByName(@PathVariable String name) {
            Image image = imageService.getImageByName(name);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getType()))
                .body(new byte[]{image.getContent()});
    }
}
