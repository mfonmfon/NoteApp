package com.semicolon.africa.mynoteapp.services;

import com.semicolon.africa.mynoteapp.data.model.Note;
import com.semicolon.africa.mynoteapp.data.repository.NoteRepository;
import com.semicolon.africa.mynoteapp.dto.Request.AddNoteRequest;
import com.semicolon.africa.mynoteapp.dto.Request.UpdateNoteRequest;
import com.semicolon.africa.mynoteapp.dto.Response.AddNoteResponse;
import com.semicolon.africa.mynoteapp.dto.Response.UpdateNoteResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoteServicesImplTest {

    @Autowired
    private NoteServices noteServices;
    @Autowired
    private HttpServletResponse httpServletResponse;

    @Test
    void createNote() {
        AddNoteRequest request = new AddNoteRequest();
        request.setTitle("Title");
        request.setContent("Content");
        AddNoteResponse response = noteServices.createNote(request);
        assertThat(response).isNotNull();
        assertThat(response.getNoteId()).isNotNull();
        assertThat(noteServices.getTotalNote()).isEqualTo(6L);
    }

    @Test
    void updateNoteWithTest() {
        AddNoteRequest request = new AddNoteRequest();
        request.setTitle(" new Title");
        request.setContent(" new Content");
//        request.setDateCreated(LocalDateTime.now());
//        UpdateNoteResponse response = noteServices.updateNoteWith(request);
    }

    @Test
    void deleteNoteTest() {

    }
}