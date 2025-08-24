package com.example.nextLearnServer.mapper;

import com.example.nextLearnServer.pojo.Gallery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GalleryMapper {
    //Get all the daily photos of life
    public List<Gallery> getAllGallery();
}

