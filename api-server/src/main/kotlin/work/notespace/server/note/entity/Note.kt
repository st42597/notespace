package work.notespace.server.note.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import work.notespace.server.note.dto.NoteDto

@Entity
class Note(
    @Id
    @Column
    val slug: String,

    @Column(nullable = false)
    var name: String,

    @Column
    var description: String,
) : Date() {
    fun toDto(): NoteDto {
        return NoteDto(
            slug = slug,
            name = name,
            description = description,
        )
    }
}
