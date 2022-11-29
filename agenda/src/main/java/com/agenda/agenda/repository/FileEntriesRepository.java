package com.agenda.agenda.repository;

import com.agenda.agenda.model.FileEntries;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileEntriesRepository extends MongoRepository<FileEntries, String> {
    public FileEntries findBy_id(String _id);
}
