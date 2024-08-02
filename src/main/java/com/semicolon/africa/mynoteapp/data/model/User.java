package com.semicolon.africa.mynoteapp.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String password;
    @DBRef
    private List<Note> noteList = new ArrayList<>();
}