package com.semicolon.africa.mynoteapp.dto.Request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AddNoteRequest {
    private String noteId;
    private String title;
    private String content;
    private LocalDateTime dateCreated;
}
