package com.example.server.note.service;

import com.example.server.note.repository.MarkdownRepository;
import com.example.server.note.domain.Markdown;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarkdownServiceImpl {
    private final MarkdownRepository markdownRepository;

    public Optional<Markdown> getMarkdown(String slug) {
        return markdownRepository.findBySlug(slug);
    }

    public Markdown updateMarkdown(String slug, String content) {
        Markdown markdown = markdownRepository.findBySlug(slug).orElseThrow(() -> new IllegalArgumentException("해당 slug가 없습니다: " + slug));
        markdown.setContent(content);
        return markdownRepository.save(markdown);
    }

    public Markdown saveMarkdown(Markdown note) {
        return markdownRepository.save(note);
    }
}
