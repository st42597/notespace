package work.notespace.botserver.bot.config

import feign.RequestInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenAiFeignConfig {
    @Bean
    fun requestInterceptor(): RequestInterceptor {
        return RequestInterceptor { template ->
            template.header("Authorization", "Bearer ${System.getenv("OPENAI_API_KEY")}")
            template.header("Content-Type", "application/json")
        }
    }
}