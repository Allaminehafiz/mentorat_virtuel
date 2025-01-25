package com.mentorat_virtuel.projet_mentorat_virtuel.service.image;

import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Image;
import com.mentorat_virtuel.projet_mentorat_virtuel.repository.ImageRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService{
    private final ImageRepo imageRepo;

    public ImageServiceImpl(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    @Override
    public Image storeImage(MultipartFile file) throws IOException {
            String fileName = file.getOriginalFilename();
            String fileType = file.getContentType();

            Image image = new Image(fileName, fileType, file.getBytes());

            return imageRepo.save(image);
        }



    @Override
    public Image getImageById(Integer id) {
        return imageRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found with id " + id));
    }

    @Override
    public Image getImageByName(String name) {
        return imageRepo.findByName(name)
                .orElseThrow(() -> new RuntimeException("Image not found with name " + name));
    }

}
