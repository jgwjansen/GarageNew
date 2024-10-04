package com.example.garagenew.controller.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.garagenew.service.FileprocessingService;
@Controller
@RequestMapping("/bestand")
public class FileprocessingController {
    @Autowired
    private FileprocessingService fileProcessingService;

    @GetMapping("/list")
    public ResponseEntity<?> getFileList() {
        return new ResponseEntity<>(fileProcessingService.fileList(), HttpStatus.OK);
    }
    //download bestand
    @GetMapping(value = "/download/{name}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<?> downloadFile(@PathVariable(value = "name") String fileName) {
        Resource file = fileProcessingService.downloadFile(fileName);
        if (file == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(file);
        }
    }
    //upload nieuw bestand
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestBody MultipartFile file) {
        String status = fileProcessingService.uploadFile(file);
        return "CREATED".equals(status) ? new ResponseEntity<>(HttpStatus.CREATED) : ("EXIST".equals(status) ? new ResponseEntity<>(HttpStatus.NOT_MODIFIED) : new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED));
    }
}
