package com.agenda.agenda.servicies;

import com.agenda.agenda.model.FileEntries;
import com.agenda.agenda.repository.FileEntriesRepository;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import javax.activation.MimetypesFileTypeMap;
import java.io.*;

@Service
public class FileEntriesService {
    @Autowired
    FileEntriesRepository repo;

     public FileEntries uploadFile(MultipartFile file) throws IOException, MimeTypeParseException {
        FileEntries fileEntries = new FileEntries();
        MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();

        fileEntries.setFileName(file.getOriginalFilename());
        fileEntries.setBaseFileName((FilenameUtils.getBaseName(file.getOriginalFilename() )));
        fileEntries.setExtension(FilenameUtils.getExtension(file.getOriginalFilename() ) );
        fileEntries.setContent(file.getBytes());
        fileEntries.setSize(file.getSize());
        fileEntries.setMimeType(mimetypesFileTypeMap.getContentType(file.getOriginalFilename()));

        repo.save(fileEntries);
        return  fileEntries;
    }


    public FileEntries downloadFile(String id) {
        FileEntries fileEntries = repo.findBy_id(id);
        return  fileEntries;
     }
}
