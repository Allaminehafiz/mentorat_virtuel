package com.mentorat_virtuel.projet_mentorat_virtuel.service.image;

import com.mentorat_virtuel.projet_mentorat_virtuel.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    public Image storeImage(MultipartFile file) throws IOException;
    public Image getImageById(Integer id);
    public Image getImageByName(String name);

}
