package work.notespace.server.note.service

import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import work.notespace.server.note.controller.request.NoteWithContentRequest
import work.notespace.server.note.dto.NoteDto
import work.notespace.server.note.entity.Markdown
import work.notespace.server.note.entity.Note
import work.notespace.server.note.repository.MarkdownRepository
import work.notespace.server.note.repository.NoteRepository

@Service
class NoteService(
    private val noteRepository: NoteRepository,
    private val markdownRepository: MarkdownRepository
) {
    fun getNote(slug: String): NoteDto {
        val note = noteRepository.findBySlug(slug)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found for slug='$slug'")
        return note.toDto()
    }

    fun getNotes(
        page: Int,
        limit: Int,
    ): Page<NoteDto> {
        val pageRequest = PageRequest.of(page, limit)
        return noteRepository.findAll(pageRequest).map { it.toDto() }
    }

    @Transactional
    fun createNote(
        slug: String,
        name: String,
        description: String,
        content: String
    ): NoteDto {
        if (noteRepository.existsBySlug(slug)) {
            throw IllegalArgumentException("A note with slug='${slug}' already exists")
        }

        val slugRegex = Regex("^[a-z0-9-]+$") 
        if (!slugRegex.matches(slug)) {
            throw IllegalArgumentException("Invalid slug: '$slug'. Only lowercase letters, numbers, and hyphens are allowed.")
        }

        val note = Note(
            slug = slug,
            name = name,
            description = description,
        )
        val markdown = Markdown(
            slug = slug,
            content = content
        )

        noteRepository.save(note)
        markdownRepository.save(markdown)

        return note.toDto()
    }

    fun deleteNote(slug: String) {
        noteRepository.deleteById(slug)
    }

    fun getRecentCreatedNotes(limit: Int): List<NoteDto> {
        val pageRequest = PageRequest.of(0, limit)
        val notes = noteRepository.findAllByOrderByCreatedAtDesc(pageRequest).map { it.toDto() }
        
        return notes
    }

    fun getRecentUpdatedNotes(limit: Int): List<NoteDto> {
        val pageRequest = PageRequest.of(0, limit)
        val notes = noteRepository.findAllByOrderByUpdatedAtDesc(pageRequest).map { it.toDto() }
        
        return notes
    }

    fun getRandomNote(): NoteDto {
        val notes = noteRepository.findAll()
        if (notes.isEmpty()) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "No notes available")
        }
        val randomNote = notes.random()
        
        return randomNote.toDto()
    }
}