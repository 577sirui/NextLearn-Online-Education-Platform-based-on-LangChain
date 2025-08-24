package com.example.nextLearnServer.service;

import com.example.nextLearnServer.pojo.Gallery;

import java.util.List;

public interface GalleryService {
    //获取全部生活日常照片
    public List<Gallery> getAllGallery();
}
