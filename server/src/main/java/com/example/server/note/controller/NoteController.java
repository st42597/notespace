package com.example.server.note.controller;

import com.example.server.note.service.NoteServiceImpl;
import com.example.server.note.domain.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NoteController {
    private final NoteServiceImpl noteService;

    @GetMapping("/notes")
    public String getNote() {
        return "note message";
    }

    @PostMapping("/notes")
    public Note postNote(@RequestBody Note note) {
        return noteService.saveNote(note);
    }
}
