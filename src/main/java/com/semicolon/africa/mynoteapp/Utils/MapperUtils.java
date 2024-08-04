package com.semicolon.africa.mynoteapp.Utils;

import com.semicolon.africa.mynoteapp.data.model.Note;
import com.semicolon.africa.mynoteapp.dto.Request.AddNoteRequest;
import com.semicolon.africa.mynoteapp.dto.Response.AddNoteResponse;

import java.time.LocalDateTime;

public class MapperUtils {
    public static AddNoteResponse map(Note note){
        AddNoteResponse response = new AddNoteResponse();
        response.setTitle(response.getTitle());
        response.setContent(response.getContent());
        response.setDateCreated(LocalDateTime.now());
        return response;
    }
    public static void map(AddNoteRequest request, Note note){
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setDateCreated(request.getDateCreated());
    }
}
