package com.semicolon.africa.mynoteapp.services;

import com.semicolon.africa.mynoteapp.data.model.Note;
import com.semicolon.africa.mynoteapp.dto.Request.AddNoteRequest;
import com.semicolon.africa.mynoteapp.dto.Request.UpdateNoteRequest;
import com.semicolon.africa.mynoteapp.dto.Response.AddNoteResponse;
import com.semicolon.africa.mynoteapp.dto.Response.DeleteNoteResponse;
import com.semicolon.africa.mynoteapp.dto.Response.UpdateNoteResponse;

import java.util.List;

public interface NoteServices {
    AddNoteResponse createNote(AddNoteRequest request);
    long getTotalNote();
    UpdateNoteResponse updateNoteWith(UpdateNoteRequest noteRequest);
    DeleteNoteResponse deleteNote(String id);
    List<Note>  getAllNote();

}
