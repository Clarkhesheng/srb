package com.atguigu.srb.oss.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    /**
     * 文件上传至阿里云
     */
    String upload(MultipartFile file, String module, String fileName);

    void removeFile(String url);
}
