package work.notespace.botserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableScheduling
@EnableFeignClients(basePackages = ["work.notespace.botserver.bot.client"])
class BotServerApplication

fun main(args: Array<String>) {
    runApplication<BotServerApplication>(*args)
}
