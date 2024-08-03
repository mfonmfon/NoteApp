package com.semicolon.africa.mynoteapp.services;

import com.semicolon.africa.mynoteapp.dto.Request.AddNoteRequest;
import com.semicolon.africa.mynoteapp.dto.Request.UpdateNoteRequest;
import com.semicolon.africa.mynoteapp.dto.Response.AddNoteResponse;
import com.semicolon.africa.mynoteapp.dto.Response.DeleteNoteResponse;
import com.semicolon.africa.mynoteapp.dto.Response.UpdateNoteResponse;

public interface NoteServices {
    AddNoteResponse createNote(AddNoteRequest request);
    long getTotalNote();
    UpdateNoteResponse updateNoteWith(UpdateNoteRequest noteRequest);
    DeleteNoteResponse deleteNote(String id);
}
