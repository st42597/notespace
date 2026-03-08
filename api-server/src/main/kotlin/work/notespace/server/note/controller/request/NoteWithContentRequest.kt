package work.notespace.server.note.controller.request

class NoteWithContentRequest(
    val slug: String,
    val name: String,
    val description: String,
    val content: String?,
)