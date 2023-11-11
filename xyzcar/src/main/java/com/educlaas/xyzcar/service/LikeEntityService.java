package com.educlaas.xyzcar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.entity.LikeEntity;
import com.educlaas.xyzcar.repository.LikeRepository;

@Service
public class LikeEntityService {

    @Autowired
    private LikeRepository likeRepository;

    public List<LikeEntity> getAllLikes() {
        return likeRepository.findAll();
    }

    public Optional<LikeEntity> getLikeById(Long id) {
        return likeRepository.findById(id);
    }

    public LikeEntity createLike(LikeEntity likeEntity) {
        return likeRepository.save(likeEntity);
    }

    public LikeEntity updateLike(LikeEntity likeEntity) {
        return likeRepository.save(likeEntity);
    }

    public void deleteLike(Long id) {
    	likeRepository.deleteById(id);
    }
}
