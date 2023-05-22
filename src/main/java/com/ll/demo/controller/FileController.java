package com.ll.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {


    @RequestMapping("/download")
    public String downloadFile(HttpServletResponse response, @RequestParam("fileName") String fileName) {
        return downloadFile(fileName, response);
    }

    private String downloadFile(String fileName, HttpServletResponse response) {
        String path = System.getProperty("user.dir");
        Path resolve = Paths.get(path).resolve(fileName);
        File file = resolve.toFile();
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
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
}
