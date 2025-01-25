package com.mentorat_virtuel.projet_mentorat_virtuel.controller;


import com.mentorat_virtuel.projet_mentorat_virtuel.entities.ImageEntity;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.fonctionnaliteavance.ImageServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageServiceImpl imageService;

    public ImageController(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = imageService.storeImage(file);
            return ResponseEntity.ok("Fichier enregistré: " + fileName);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors de l'upload : " + e.getMessage());
        }
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<ImageEntity> getImage(@PathVariable String fileName) {
        ImageEntity image = imageService.getImageByName(fileName);
        return ResponseEntity.ok(image);
    }
}

