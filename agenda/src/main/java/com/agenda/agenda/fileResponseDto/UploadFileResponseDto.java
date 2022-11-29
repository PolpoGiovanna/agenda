package com.agenda.agenda.fileResponseDto;

import com.agenda.agenda.model.FileEntries;

public class UploadFileResponseDto {
    private FileEntries fileEntries;

    public UploadFileResponseDto(FileEntries fileEntries) {
        this.fileEntries = fileEntries;
    }

    public FileEntries getFileEntries() {
        return fileEntries;
    }

    public void setFileEntries(FileEntries fileEntries) {
        this.fileEntries = fileEntries;
    }
}
