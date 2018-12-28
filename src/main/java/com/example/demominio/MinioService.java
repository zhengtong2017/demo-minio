package com.example.demominio;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * MinioService
 *
 * @Author zhengtong
 * @Date 2018/12/28 10:22
 */
@Service
@Slf4j
public class MinioService {


    @Autowired
    MinioUtil minioUtil;

    public String uploadToMinio(String bucketName, String fileName, MultipartFile file) {

        try {
            return minioUtil.upload(bucketName, fileName, file.getInputStream());
        } catch (IOException e) {
            log.error("[MinioService-uploadToMinio]: upload to S3 failed!");
            return null;
        }
    }
}
