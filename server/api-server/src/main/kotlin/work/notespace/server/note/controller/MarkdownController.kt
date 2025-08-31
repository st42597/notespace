package work.notespace.server.note.controller

import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import work.notespace.server.note.controller.request.MarkdownRequest
import work.notespace.server.note.dto.MarkdownDto
import work.notespace.server.note.service.MarkdownService

@RestController
@Validated
class MarkdownController(
    private val markdownService: MarkdownService
) {

    @GetMapping("/notes/{slug}/markdown")
    fun getMarkdown(
        @PathVariable
        @Valid
        slug: String
    ): MarkdownDto {
        return markdownService.getMarkdown(slug)
    }

    @PatchMapping("/notes/{slug}/markdown")
    fun patchMarkdown(
        @PathVariable
        slug: String,
        @RequestBody
        @Valid
        markdown: MarkdownRequest
    ): MarkdownDto {
        return markdownService.updateMarkdown(slug, markdown.content)
    }
}
