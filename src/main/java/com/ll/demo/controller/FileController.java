package com.ll.demo.controller;


import com.ll.demo.common.R;
import com.ll.demo.dto.UserDto;
import com.ll.demo.entity.DBFile;
import com.ll.demo.service.DBFileStorageService;
import com.ll.demo.storage.StorageFileNotFoundException;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {
    @RequestMapping("/download")
    @Hidden
    public String downloadFile(HttpServletResponse response, @RequestParam("fileName") String fileName) {
        return downloadFile(fileName, response);
    }

    private String downloadFile(String fileName, HttpServletResponse response) {
        String path = System.getProperty("user.dir");
        Path resolve = Paths.get(path).resolve(fileName);
        File file = resolve.toFile();
        response.reset();
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        UserDto userDto = new UserDto();
        userDto.setAge(18);
        userDto.setName("ll");
        response.setHeader("result", "success");
        System.out.println(userDto.toString());
        response.setHeader("user", userDto.toString());

        if (fileName.equals("1")){
            return "failed";
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
            byte[] buff = new byte[1024];
            OutputStream os = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            log.error("{}", e);
            return "error";

        }
        return "ok";
    }

    @Autowired
    private DBFileStorageService dbFileStorageService;
    @Operation(summary = "上传图片", description = "", tags = {"aaa接口看这里"})
    @PostMapping("/upload")
    public R<?> upload(@RequestParam("file") MultipartFile file) throws IOException {

        String fileName = file.getOriginalFilename();

        DBFile dbFile = new DBFile();
        dbFile.setFileName(fileName);
        dbFile.setFileType(file.getContentType());
        dbFile.setData(file.getBytes());
        dbFileStorageService.save(dbFile);

        return R.success(dbFile.getId());
    }

    @Operation(summary = "下载图片", description = "", tags = {"aaa接口看这里"})
    @GetMapping("/download/{file_id}")
    public ResponseEntity<Resource> download(@PathVariable Long file_id) {

        DBFile dbFile  = dbFileStorageService.getById(file_id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }


//    @ExceptionHandler(StorageFileNotFoundException.class)
//    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
//        return ResponseEntity.notFound().build();
//    }

}
