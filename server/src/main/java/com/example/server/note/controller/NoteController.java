package com.example.server.note.controller;

import com.example.server.note.domain.Markdown;
import com.example.server.note.service.MarkdownServiceImpl;
import com.example.server.note.service.NoteServiceImpl;
import com.example.server.note.domain.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class NoteController {
    private final NoteServiceImpl noteService;
    private final MarkdownServiceImpl markdownService;

    @GetMapping("/notes")
    public List<Note> getNotes() {
        return noteService.getNotes();
    }

    @GetMapping("/notes/{slug}")
    public ResponseEntity<Note> getNote(@PathVariable String slug) {
        return noteService.getNote(slug)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/notes")
    public Note postNote(@RequestBody Note note) {
        Markdown md = new Markdown();
        md.setSlug(note.getSlug());
        md.setContent("");
        markdownService.saveMarkdown(md);
        return noteService.saveNote(note);
    }
}
