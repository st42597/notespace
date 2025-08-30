package work.notespace.llmserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LlmServerApplication

fun main(args: Array<String>) {
    runApplication<LlmServerApplication>(*args)
}
