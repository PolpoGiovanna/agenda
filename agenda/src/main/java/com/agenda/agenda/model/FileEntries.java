package com.agenda.agenda.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.InputStream;

@Document
public class FileEntries {
    private String _id;
    private String fileName;
    private String baseFileName;
    private String extension;
    private String mimeType;
    private long size;
    private byte[] content;

    public FileEntries() {
    }

    public FileEntries(String fileName, String baseFileName, String extension, String mimeType, long size, byte[] content) {
        this.fileName = fileName;
        this.baseFileName = baseFileName;
        this.extension = extension;
        this.mimeType = mimeType;
        this.size = size;
        this.content = content;
    }

    public FileEntries(String _id) {
        this._id = _id;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getBaseFileName() {
        return baseFileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBaseFileName(String baseName) {
        return baseFileName;
    }

    public void setBaseFileName(String baseFileName) {
        this.baseFileName = baseFileName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
