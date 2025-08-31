package work.notespace.botserver.bot.client.request

data class GptRequest(
    val model: String,
    val input: String
)