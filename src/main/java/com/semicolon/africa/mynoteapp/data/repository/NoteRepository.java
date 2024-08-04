package com.semicolon.africa.mynoteapp.data.repository;

import com.semicolon.africa.mynoteapp.data.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface NoteRepository extends MongoRepository<Note, String> {
    boolean existsByTitle(String title);

}
