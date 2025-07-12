package work.notespace.server.note.service

import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
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
            ?: throw EntityNotFoundException("Note not found for slug='$slug'")

        return note.toDto()
    }

    fun getNotes(): List<NoteDto> {
        return noteRepository.findAll().map { it.toDto() }
    }

    @Transactional
    fun createNote(req: NoteDto): NoteDto {
        val note = Note(
            slug = req.slug,
            name = req.name,
            description = req.description,
        )
        val markdown = Markdown(slug = req.slug)

        noteRepository.save(note)
        markdownRepository.save(markdown)

        return note.toDto()
    }

    fun deleteNote(slug: String) {
        noteRepository.deleteById(slug)
    }
}