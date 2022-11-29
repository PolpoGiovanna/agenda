package com.agenda.agenda.fileResponseDto;

import com.agenda.agenda.model.FileEntries;
import org.springframework.core.io.InputStreamResource;

public class DownloadFileResponseDto {
    private InputStreamResource inputStreamResource;

    public DownloadFileResponseDto(InputStreamResource inputStreamResource) {
        this.inputStreamResource = inputStreamResource;
    }

    public InputStreamResource getInputStreamResource() {
        return inputStreamResource;
    }

    public void setInputStreamResource(InputStreamResource inputStreamResource) {
        this.inputStreamResource = inputStreamResource;
    }
}
