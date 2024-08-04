package com.semicolon.africa.mynoteapp.services;

import com.semicolon.africa.mynoteapp.data.model.Note;
import com.semicolon.africa.mynoteapp.data.repository.NoteRepository;
import com.semicolon.africa.mynoteapp.dto.Request.AddNoteRequest;
import com.semicolon.africa.mynoteapp.dto.Request.UpdateNoteRequest;
import com.semicolon.africa.mynoteapp.dto.Response.AddNoteResponse;
import com.semicolon.africa.mynoteapp.dto.Response.DeleteNoteResponse;
import com.semicolon.africa.mynoteapp.dto.Response.UpdateNoteResponse;
import com.semicolon.africa.mynoteapp.exception.NoteNotFoundException;
import com.semicolon.africa.mynoteapp.exception.TitleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;

import static com.semicolon.africa.mynoteapp.Utils.MapperUtils.map;

@Service
public class NoteServicesImpl implements NoteServices{

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public AddNoteResponse createNote(AddNoteRequest request) {
        validateTitle(request.getTitle());
        Note note = new Note();
        map(request,note);
        noteRepository.save(note);
        return map(note);
    }

    private void validateTitle(String title){
        boolean isTitleExist = noteRepository.existsByTitle(title);
        if(isTitleExist)throw new TitleNotFoundException(title + "Already Exist ");
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
        response.setMessage("note updated");
        return response;
    }

    @Override
    public DeleteNoteResponse deleteNote(String noteId) {
        Note note = findById(noteId);
        noteRepository.delete(note);
        DeleteNoteResponse response = new DeleteNoteResponse();
        response.setMessage("Message deleted");
        return response;
    }

    @Override
    public List<Note> getAllNote() {
        return noteRepository.findAll();
    }

    private Note findById(String id){
       return noteRepository.findById(id).
               orElseThrow(()-> new NoteNotFoundException("Note not found"));
    }
}