package com.semicolon.africa.mynoteapp.services;

import com.semicolon.africa.mynoteapp.data.model.Note;
import com.semicolon.africa.mynoteapp.data.repository.NoteRepository;
import com.semicolon.africa.mynoteapp.dto.Request.AddNoteRequest;
import com.semicolon.africa.mynoteapp.dto.Request.UpdateNoteRequest;
import com.semicolon.africa.mynoteapp.dto.Response.AddNoteResponse;
import com.semicolon.africa.mynoteapp.dto.Response.DeleteNoteResponse;
import com.semicolon.africa.mynoteapp.dto.Response.UpdateNoteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NoteServicesImpl implements NoteServices{

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public AddNoteResponse createNote(AddNoteRequest request) {
        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setDateCreated(LocalDateTime.now());
        noteRepository.save(note);
        AddNoteResponse response = new AddNoteResponse();
        note.setTitle(response.getTitle());
        note.setContent(response.getContent());
        note.setDateCreated(response.getDateCreated());
        return response;
    }

    @Override
    public long getTotalNote() {
        return 0;
    }

    @Override
    public UpdateNoteResponse updateNoteWith(UpdateNoteRequest noteRequest) {
        return null;
    }

    @Override
    public DeleteNoteResponse deleteNote(String id) {
        return null;
    }
}
