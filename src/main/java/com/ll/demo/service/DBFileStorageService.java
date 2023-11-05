package com.ll.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ll.demo.entity.DBFile;
import com.ll.demo.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DBFileStorageService extends ServiceImpl<FileMapper, DBFile> {

    @Autowired
    private FileMapper fileMapper;

    public void storeFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            DBFile dbFile = new DBFile();
            dbFile.setFileName(fileName);
            dbFile.setFileType(file.getContentType());
            dbFile.setData(file.getBytes());

            fileMapper.insert(dbFile);
        } catch (IOException ex) {
            throw new RuntimeException("Error storing file " + fileName, ex);
        }
    }
}
