package com.example.server.note.service;

import com.example.server.note.repository.NoteRepository;
import com.example.server.note.domain.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl {
    private final NoteRepository noteRepository;

    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNote(String slug) {
        return noteRepository.findById(slug);
    }

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    public void deleteNote(String slug) {
        noteRepository.deleteById(slug);
    }
}
