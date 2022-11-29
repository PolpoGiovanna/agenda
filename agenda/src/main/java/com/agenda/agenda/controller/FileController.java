package com.agenda.agenda.controller;

import com.agenda.agenda.fileRequestDto.DownloadFileRequestDto;
import com.agenda.agenda.fileRequestDto.UploadFileRequestDto;
import com.agenda.agenda.fileResponseDto.DownloadFileResponseDto;
import com.agenda.agenda.fileResponseDto.UploadFileResponseDto;
import com.agenda.agenda.model.FileEntries;
import com.agenda.agenda.servicies.FileEntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimeTypeParseException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileEntriesService servicies;

    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public ResponseEntity<UploadFileResponseDto> uploadFile(@RequestParam( name = "file") MultipartFile request) throws IOException, MimeTypeParseException {
          FileEntries fileEntries = servicies.uploadFile(request);
        return ResponseEntity.status(200).body(new UploadFileResponseDto(fileEntries));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/download")
    public ResponseEntity<InputStreamResource> downloadFile(@RequestBody DownloadFileRequestDto request) throws IOException {
        FileEntries fileEntries = servicies.downloadFile(request.get_id());
        InputStream inputStream = new ByteArrayInputStream(fileEntries.getContent());
        return ResponseEntity
                .status(200)
                .contentType(MediaType.parseMediaType(fileEntries.getMimeType()))
                .body(new InputStreamResource(inputStream));
    }


}
