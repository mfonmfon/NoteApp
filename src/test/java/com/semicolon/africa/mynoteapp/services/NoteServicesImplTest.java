package com.semicolon.africa.mynoteapp.services;

import com.semicolon.africa.mynoteapp.data.model.Note;
import com.semicolon.africa.mynoteapp.data.repository.NoteRepository;
import com.semicolon.africa.mynoteapp.dto.Request.AddNoteRequest;
import com.semicolon.africa.mynoteapp.dto.Request.UpdateNoteRequest;
import com.semicolon.africa.mynoteapp.dto.Response.AddNoteResponse;
import com.semicolon.africa.mynoteapp.dto.Response.UpdateNoteResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
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
    private NoteRepository noteRepository;

    @BeforeEach
    public void setUp(){
        noteRepository.deleteAll();
    }
    @Test
    void createNoteTest() {
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
        AddNoteResponse response = createMyNote();
        UpdateNoteRequest request = new UpdateNoteRequest();
        request.setId(response.getNoteId());
        request.setTitle("new Title");
        request.setContent("new Content");
        UpdateNoteResponse response1 = noteServices.updateNoteWith(request);
        assertThat(response1.getTitle()).contains("Updated");
        assertThat(response.getNoteId()).isEqualTo(request.getId());

    }

    private AddNoteResponse createMyNote() {
            AddNoteRequest request = new AddNoteRequest();
            request.setTitle(" new Title");
            request.setContent(" new Content");
            return noteServices.createNote(request);

    }

    @Test
    void deleteNoteTest() {

    }

}