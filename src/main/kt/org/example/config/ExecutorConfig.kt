package org.example.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Configuration
class ExecutorConfig {

    @Value("\${executor.thread.pool.size}")
    private var threadPoolSize: Int = 0

    @Bean(name = ["fixedThreadPool"])
    fun fixedThreadPool(): ExecutorService {
        return Executors.newFixedThreadPool(threadPoolSize)
    }

    @Bean(name = ["scheduledThreadPool"])
    fun scheduledThreadPool(): ExecutorService {
        return Executors.newScheduledThreadPool(1)
    }
}