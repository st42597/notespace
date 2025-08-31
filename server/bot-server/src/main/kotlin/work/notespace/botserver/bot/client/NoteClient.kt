package work.notespace.botserver.bot.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import work.notespace.botserver.bot.dto.NoteDto
import work.notespace.botserver.bot.client.request.CreateNoteRequest

@FeignClient(name = "noteApi", url = "http://notespace-api-server:5000")
interface NoteClient {
    @GetMapping("/notes")
    fun getNote(
        @RequestParam page: Int,
        @RequestParam limit: Int
    ): Page<NoteDto>
    
    @PostMapping("/notes")
    fun createNote(
        @RequestBody noteContent: CreateNoteRequest
    ): NoteDto
}