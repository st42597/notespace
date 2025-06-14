package com.example.server.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.server.note.domain.Note;

public interface NoteRepository extends JpaRepository<Note, String> {
}
