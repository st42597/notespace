package work.notespace.botserver.bot.client.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class GptResponse(
    val output: List<GptMessage>? = emptyList()
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class GptMessage(
    val content: List<GptContent>? = emptyList()
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class GptContent(
    val text: String? = ""
)

fun GptResponse.getFirstOutputText(): String? {
    return this.output
        ?.firstOrNull()
        ?.content
        ?.firstOrNull()
        ?.text ?: ""
}