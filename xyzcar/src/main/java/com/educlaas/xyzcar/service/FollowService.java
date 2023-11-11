package com.educlaas.xyzcar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.entity.Follow;
import com.educlaas.xyzcar.repository.FollowRepository;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    public List<Follow> getAllFollows() {
        return followRepository.findAll();
    }

    public Optional<Follow> getFollowById(Long id) {
        return followRepository.findById(id);
    }

    public Follow createFollow(Follow follow) {
        return followRepository.save(follow);
    }

    public Follow updateFollow(Follow follow) {
        return followRepository.save(follow);
    }

    public void deleteFollow(Long id) {
        followRepository.deleteById(id);
    }
}
