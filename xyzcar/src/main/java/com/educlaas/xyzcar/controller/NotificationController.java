package com.educlaas.xyzcar.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.xyzcar.service.NotificationLogService;

@RestController
@RequestMapping("/xyz/notifications")
@CrossOrigin(origins = "http://localhost:3000")
public class NotificationController {

    @Autowired
    private NotificationLogService notificationLogService;

//    // Function 20: Get post tabulation (likes, comments, shares)
//    @GetMapping("/get/post/tabulation/{postId}")
//    public ResponseEntity<PostTabulationDTO> getPostTabulation(@PathVariable Long postId) {
//
//        // Call the service method to get post tabulation
//        PostTabulationDTO postTabulation = notificationLogService.getPostTabulation(postId);
//
//        // Return the post tabulation and a HTTP status code indicating success
//        return new ResponseEntity<>(postTabulation, HttpStatus.OK);
//    }
    
    
    
 // Function 20: Get post tabulation (likes, comments, shares)
    @GetMapping("/get/post/tabulation/{postId}")
    public ResponseEntity<Map<String, Long>> getPostTabulation(@PathVariable Long postId) {

        // Call the service method to get post tabulation
        Map<String, Long> postTabulation = notificationLogService.getPostTabulation(postId);

        // Return the post tabulation and a HTTP status code indicating success
        return new ResponseEntity<>(postTabulation, HttpStatus.OK);
    }


}