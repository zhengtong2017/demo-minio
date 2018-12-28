package com.example.demominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * MinioController
 *
 * @Author zhengtong
 * @Date 2018/12/28 10:32
 */
@RestController
public class MinioController {

    @Autowired
    MinioService minioService;

    @PostMapping(value = "/minio/upload")
    public String upload(@RequestParam String bucketName,
                         @RequestParam String fileName,
                         @RequestParam MultipartFile file){
        if (StringUtils.hasText(bucketName) && StringUtils.hasText(fileName) && !file.isEmpty()) {
            return minioService.uploadToMinio(bucketName,fileName,file);
        }
        return "bucketName & fileName & file can't be null";
    }
}
