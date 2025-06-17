package com.example.server.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.server.note.domain.Markdown;

import java.util.Optional;

public interface MarkdownRepository extends JpaRepository<Markdown, Long> {
    Optional<Markdown> findBySlug(String slug);
}
