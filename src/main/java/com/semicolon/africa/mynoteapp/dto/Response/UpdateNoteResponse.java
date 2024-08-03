package com.semicolon.africa.mynoteapp.dto.Response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateNoteResponse {
    private String id;
    private String title;
    private String content;
    private LocalDateTime dateUpdated;
}