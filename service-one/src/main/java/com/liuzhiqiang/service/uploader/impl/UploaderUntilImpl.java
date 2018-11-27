package com.liuzhiqiang.service.uploader.impl;

import com.liuzhiqiang.enums.ContentType;
import com.liuzhiqiang.service.uploader.UploaderUntilService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lzq on 2018/9/22.
 */
@Service
public class UploaderUntilImpl implements UploaderUntilService {

    /**
     * 上传文件
     * @param file
     * @return
     */
    @Override
    public String createImg(MultipartFile file) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dirName = format.format(new Date());
        String loadName = file.getOriginalFilename();
        Long size = file.getSize();
        String [] nameArr = loadName.split("\\.");
        String type = nameArr[nameArr.length-1];
        String imgName = System.currentTimeMillis() + "."+nameArr[nameArr.length-1];
        ContentType contentType = ContentType.ContentTypeStr(type.toLowerCase());
        String pathI = contentType.getPath();
        try {
            if(!Files.exists(Paths.get(pathI + dirName))){
                Files.createDirectories(Paths.get(pathI + dirName));
            }
            Path path = Files.createFile(Paths.get(pathI + dirName + "/" + imgName));
            Files.write(path,file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dirName + "/" + imgName;
    }
}