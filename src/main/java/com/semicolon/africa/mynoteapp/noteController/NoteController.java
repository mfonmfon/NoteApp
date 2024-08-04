package com.semicolon.africa.mynoteapp.noteController;

import com.semicolon.africa.mynoteapp.dto.Request.AddNoteRequest;
import com.semicolon.africa.mynoteapp.dto.Request.UpdateNoteRequest;
import com.semicolon.africa.mynoteapp.dto.Response.AddNoteResponse;
import com.semicolon.africa.mynoteapp.dto.Response.ApiResponse;
import com.semicolon.africa.mynoteapp.dto.Response.UpdateNoteResponse;
import com.semicolon.africa.mynoteapp.exception.ApiResponseException;
import com.semicolon.africa.mynoteapp.services.NoteServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
public class NoteController {

    private final NoteServices noteServices;

    @PostMapping("/add-note")
    public ResponseEntity<?> addPost(@RequestBody AddNoteRequest request){
        try{
            AddNoteResponse response = noteServices.createNote(request);
            return new ResponseEntity<>(new ApiResponse(true,response), CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false,exception),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> updatePost(UpdateNoteRequest request){
        try{
            UpdateNoteResponse response = noteServices.updateNoteWith(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }
        catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false,exception), HttpStatus.BAD_REQUEST);
        }

    }

}
