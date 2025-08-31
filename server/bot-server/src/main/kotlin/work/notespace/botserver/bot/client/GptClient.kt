package work.notespace.botserver.bot.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import work.notespace.botserver.bot.client.request.GptRequest
import work.notespace.botserver.bot.client.response.GptResponse
import work.notespace.botserver.bot.dto.NoteDto
import work.notespace.botserver.bot.config.OpenAiFeignConfig

@FeignClient(
    name = "openaiClient",
    url = "https://api.openai.com/v1",
    configuration = [OpenAiFeignConfig::class]
)
interface GptClient {
    @PostMapping("/responses")
    fun getResponse(@RequestBody request: GptRequest): GptResponse
}