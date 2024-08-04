package com.semicolon.africa.mynoteapp.exception;

public class NoteNotFoundException extends  RuntimeException {
    public NoteNotFoundException(String message) {
        super(message);
    }
}
