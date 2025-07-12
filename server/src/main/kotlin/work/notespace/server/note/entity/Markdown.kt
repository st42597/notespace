package work.notespace.server.note.entity

import jakarta.persistence.*
import work.notespace.server.note.dto.MarkdownDto


@Entity
class Markdown(
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column
    val slug: String,

    @Column
    var content: String = "",
) : Date() {
    fun toDto(): MarkdownDto {
        return MarkdownDto(
            id = id,
            slug = slug,
            content = content,
        )
    }
}