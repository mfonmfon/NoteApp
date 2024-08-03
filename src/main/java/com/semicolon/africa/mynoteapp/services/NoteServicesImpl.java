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
        response.setNoteId(note.getId());
        response.setTitle(note.getTitle());
        response.setContent(note.getContent());
        response.setDateCreated(note.getDateCreated());
        return response;
    }

    @Override
    public long getTotalNote() {
        return noteRepository.count();
    }

    @Override
    public UpdateNoteResponse updateNoteWith(UpdateNoteRequest noteRequest) {
        Note note = new Note();
        UpdateNoteRequest request = new UpdateNoteRequest();
        note.setId(request.getId());
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setDateUpdated(LocalDateTime.now());
        noteRepository.save(note);
        UpdateNoteResponse response = new UpdateNoteResponse();
        response.setTitle(note.getTitle());
        response.setContent(note.getContent());
        return response;

    }

//    private Note findById(Note note) {
//        noteRepository.findById(re)
//    }

    @Override
    public DeleteNoteResponse deleteNote(String id) {
        Note note = new Note();
        AddNoteRequest request = new AddNoteRequest();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setId(request.getNoteId());
        noteRepository.delete(note);
        DeleteNoteResponse response = new DeleteNoteResponse();
        response.setMessage("Note deleted successfully. ");
        return response;
    }
}
