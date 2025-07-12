package work.notespace.server.note.dto

data class MarkdownDto(
    val id: Long? = null,
    val slug: String,
    val content: String,
)