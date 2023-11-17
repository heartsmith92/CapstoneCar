package com.educlaas.xyzcar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.entity.Share;
import com.educlaas.xyzcar.repository.ShareRepository;

@Service
public class ShareService {

    @Autowired
    private ShareRepository shareRepository;

    public List<Share> getAllShares() {
        return shareRepository.findAll();
    }

    public Optional<Share> getShareById(Long id) {
        return shareRepository.findById(id);
    }

    public Share createShare(Share share) {
        return shareRepository.save(share);
    }

    public Share updateShare(Share share) {
        return shareRepository.save(share);
    }

    public void deleteShare(Long id) {
        shareRepository.deleteById(id);
    }
    
    //function 20 
    
    public void sharePost(Long userId , Long postId) {
    	
    }
}
