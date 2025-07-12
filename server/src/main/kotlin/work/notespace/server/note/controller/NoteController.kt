package work.notespace.server.note.controller

import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import work.notespace.server.note.dto.NoteDto
import work.notespace.server.note.service.NoteService

@RestController
@Validated
class NoteController(
    private val noteService: NoteService,
    // private val markdownService: MarkdownService
) {
    @GetMapping("/notes")
    fun getNotes(): List<NoteDto> {
        return noteService.getNotes()
    }

    @GetMapping("/notes/{slug}")
    fun getNote(
        @PathVariable slug: String
    ): NoteDto {
        return noteService.getNote(slug)
    }

    @PostMapping("/notes")
    fun createNote(
        @Valid
        @RequestBody note: NoteDto
    ): NoteDto {
        return noteService.createNote(note)
    }
}
