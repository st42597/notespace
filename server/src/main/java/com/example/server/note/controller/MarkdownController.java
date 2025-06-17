package com.example.server.note.controller;

import com.example.server.note.service.MarkdownServiceImpl;
import com.example.server.note.domain.Markdown;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MarkdownController {
    private final MarkdownServiceImpl markdownService;

    @GetMapping("/notes/{slug}/markdown")
    public Optional<Markdown> getMarkdown(@PathVariable String slug) {
        return markdownService.getMarkdown(slug);
    }

    @PatchMapping("/notes/{slug}/markdown")
    public Markdown patchMarkdown(@PathVariable String slug, @RequestBody Markdown md) {
        return markdownService.updateMarkdown(slug, md.getContent());
    }
}
