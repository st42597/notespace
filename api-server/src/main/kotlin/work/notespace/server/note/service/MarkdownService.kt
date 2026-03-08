package work.notespace.server.note.service

import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import work.notespace.server.note.dto.MarkdownDto
import work.notespace.server.note.entity.Markdown
import work.notespace.server.note.repository.MarkdownRepository
import work.notespace.server.note.repository.NoteRepository

@Service
class MarkdownService(
    private val markdownRepository: MarkdownRepository,
    private val noteRepository: NoteRepository
) {
    fun getMarkdown(slug: String): MarkdownDto {
        val markdown = markdownRepository.findBySlug(slug)
            ?: throw EntityNotFoundException("Markdown not found for slug='$slug'")

        return markdown.toDto()
    }

    @Transactional
    fun updateMarkdown(slug: String, content: String): MarkdownDto {
        val markdown = markdownRepository.findBySlug(slug)
            ?: throw EntityNotFoundException("Markdown not found for slug='$slug'")
        markdown.content = content
        val savedMarkdown = markdownRepository.save(markdown)
        val note = noteRepository.findBySlug(slug)
            ?: throw EntityNotFoundException("Note not found for slug='$slug'")
        note.updatedAt = markdown.updatedAt
        noteRepository.save(note)

        return savedMarkdown.toDto()
    }

    fun createMarkdown(slug: String): MarkdownDto {
        val markdown = Markdown(slug = slug)

        return markdownRepository.save(markdown).toDto()
    }
}

