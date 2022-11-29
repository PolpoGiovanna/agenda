package com.agenda.agenda.fileRequestDto;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileRequestDto {
    private MultipartFile file;

    public UploadFileRequestDto() {
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        String nomeFile = file.getName();
    }
}
