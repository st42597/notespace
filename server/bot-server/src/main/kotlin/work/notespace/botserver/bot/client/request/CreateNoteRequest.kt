package work.notespace.botserver.bot.client.request

data class CreateNoteRequest(
    val slug: String,
    val name: String,
    val description: String,
    val content: String,
)