package com.semicolon.africa.mynoteapp.dto.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateNoteRequest {
    private String id;
    private String title;
    private String content;
}
