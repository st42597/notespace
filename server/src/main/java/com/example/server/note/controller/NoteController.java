package com.example.server.note.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesController {
    @GetMapping("/notes")
    public String getNote() {
        return "note message";
    }

    @PostMapping("/notes/{id}")
    public String postNote(@PathVariable String id) {
        return "text";
    }
}
