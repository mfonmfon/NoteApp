package com.semicolon.africa.mynoteapp.data.repository;

import com.semicolon.africa.mynoteapp.data.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {
}
