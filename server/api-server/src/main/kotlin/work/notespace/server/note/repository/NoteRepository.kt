package work.notespace.server.note.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import work.notespace.server.note.entity.Note

@Repository
interface NoteRepository : JpaRepository<Note, String> {
    fun findBySlug(slug: String): Note?
    fun findAllByOrderByCreatedAtDesc(pageRequest: Pageable): List<Note>
    fun findAllByOrderByUpdatedAtDesc(pageRequest: Pageable): List<Note>
    fun existsBySlug(slug: String): Boolean
    @Query(value = "SELECT * FROM note LIMIT 1 OFFSET :offset", nativeQuery = true)
    fun findRandomWithOffset(offset: Int): Note
}