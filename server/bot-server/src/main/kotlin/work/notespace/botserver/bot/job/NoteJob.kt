package work.notespace.botserver.bot.job

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import work.notespace.botserver.bot.service.NoteService

@Component
class NoteJob(
    private val noteService: NoteService
) {
    @Scheduled(cron = "0,30 * * * * *")
    fun createNote() {
        noteService.createNote()
    }
}