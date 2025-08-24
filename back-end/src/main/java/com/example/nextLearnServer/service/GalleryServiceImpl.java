package com.example.nextLearnServer.service;

import com.example.nextLearnServer.mapper.GalleryMapper;
import com.example.nextLearnServer.pojo.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryServiceImpl implements GalleryService{

    @Autowired
    private GalleryMapper galleryMapper;

    @Override
    public List<Gallery> getAllGallery() {
        return galleryMapper.getAllGallery();
    }
}
