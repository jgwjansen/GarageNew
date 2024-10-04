package com.example.garagenew.service;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
public interface FileprocessingService {
    List<String> fileList();

    String uploadFile(MultipartFile file);

    Resource downloadFile(String fileName);
}
