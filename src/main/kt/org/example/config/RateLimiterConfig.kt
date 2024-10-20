package org.example.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.Semaphore

@Configuration
class RateLimiterConfig {
    @Bean
    fun rateLimiter(): Semaphore {
        return Semaphore(5)
    }
}