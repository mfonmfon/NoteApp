package com.semicolon.africa.mynoteapp.dto.Response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AddNoteResponse {
    private String noteId;
    private String title;
    private String content;
    private LocalDateTime dateCreated;
}
