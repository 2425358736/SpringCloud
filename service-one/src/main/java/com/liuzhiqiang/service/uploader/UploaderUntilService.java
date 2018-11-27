package com.liuzhiqiang.service.uploader;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 刘志强
 * @created 2018/8/21.
 */
public interface UploaderUntilService {
    public String createImg(MultipartFile file);
}
