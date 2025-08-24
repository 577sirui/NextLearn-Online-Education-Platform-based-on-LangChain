package com.example.nextLearnServer.controller;

import com.example.nextLearnServer.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    @GetMapping("/gallery/getAllGallery")
    public Object getAllGallery() {
        return galleryService.getAllGallery();
    }
}
