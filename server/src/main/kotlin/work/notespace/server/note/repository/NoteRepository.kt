package work.notespace.server.note.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import work.notespace.server.note.entity.Note

@Repository
interface NoteRepository : JpaRepository<Note, String> {
    fun findBySlug(slug: String): Note?
    fun findTopNByOrderByCreatedAtDesc(pageRequest: Pageable): List<Note>
    fun findTopNByOrderByUpdatedAtDesc(pageRequest: Pageable): List<Note>
}