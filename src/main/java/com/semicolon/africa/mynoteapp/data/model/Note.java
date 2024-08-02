package com.semicolon.africa.mynoteapp.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.StandardException;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document
public class Note {
    private String id;
    private String content;
    private String title;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

}
