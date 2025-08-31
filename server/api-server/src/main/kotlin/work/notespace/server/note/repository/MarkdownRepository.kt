package work.notespace.server.note.repository

import org.springframework.data.jpa.repository.JpaRepository
import work.notespace.server.note.entity.Markdown

interface MarkdownRepository : JpaRepository<Markdown?, Long?> {
    fun findBySlug(slug: String): Markdown?
}
