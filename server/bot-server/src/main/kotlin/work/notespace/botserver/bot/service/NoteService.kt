package work.notespace.botserver.bot.service

import work.notespace.botserver.bot.client.GptClient
import work.notespace.botserver.bot.client.NoteClient
import work.notespace.botserver.bot.client.request.GptRequest
import work.notespace.botserver.bot.client.response.getFirstOutputText
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import work.notespace.botserver.bot.dto.GptGeneratedNoteDto
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import work.notespace.botserver.bot.client.request.CreateNoteRequest

@Service
class NoteService(
    private val noteClient: NoteClient,
    private val gptClient: GptClient,
) {
    private val logger = LoggerFactory.getLogger(NoteService::class.java)
    
    fun createNote() {
        val note = noteClient.getNote(page = 0, limit = 10).content
        val input = note.joinToString("\n") {
            "slug: " + it.slug +
            "name: " + it.name +
            "description: " + it.description + " 라는 게시글이 이미 존재해"
        } + "위 게시글들과 다른 주제의 게시글을 하나 작성해줘.\n" +
        "사람들의 흥미를 끄는 자극적인 주제와 내용이 핵심이야.\n" +
        "새로운 게시글을 생성하기 위한 정보를 JSON으로 만들어줘.\n" +
        "다음 필드가 반드시 있어야 한다:\n" +
        "- slug: 영어 소문자와 하이픈으로 구성된 URL 슬러그(가능한 짧은게 좋음)\n" +
        "- name: 게시글 이름 (짧게)\n" +
        "- description: 게시글 설명 (짧은 한 문장)\n" +
        "- content: 초기 게시글 내용 (plain text, 조금 길어도 괜찮음)\n" +
        "출력은 반드시 JSON만, 설명은 하지 마.\n" +
        "앞뒤에 ```json 이나 ``` 같은 마크다운 표시는 절대 붙이지 마."
        val gptResponse = gptClient.getResponse(
            GptRequest(
                model = "gpt-4.1-nano",
                input = input
            )
        )
        val gptText = gptResponse.getFirstOutputText() ?: ""
        val mapper = jacksonObjectMapper()
        val generatedNote: GptGeneratedNoteDto = mapper.readValue(gptText)
        logger.info("gpt 응답 받음: $gptText")
        noteClient.createNote(
            CreateNoteRequest(
                slug = generatedNote.slug,
                name = generatedNote.name,
                description = generatedNote.description,
                content = generatedNote.content
            )
        )
    }
}