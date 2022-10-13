package com.alkemy.ong.controller;


import com.alkemy.ong.service.impl.AmazonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/storage")
public class BucketController {

    private AmazonClient amazonClient;

    @Autowired
    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/uploadFile")
    public String uploadFiles(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonClient.uploadFiles(file);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }
}