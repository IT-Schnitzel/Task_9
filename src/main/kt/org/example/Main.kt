package org.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class YourApplication

fun main(args: Array<String>) {
    runApplication<YourApplication>(*args)
}

@Configuration
class ExecutorConfig {

    @Bean(name = ["fixedThreadPool"])
    fun fixedThreadPool(): ExecutorService {
        val threadCount = 5 // Количество потоков можно вынести в конфигурацию
        return Executors.newFixedThreadPool(threadCount).also {
            it.threadFactory = Executors.defaultThreadFactory().apply {
                name = "fixed-thread-pool-"
            }
        }
    }

    @Bean(name = ["scheduledThreadPool"])
    fun scheduledThreadPool(): ExecutorService {
        val threadCount = 2 // Количество потоков можно вынести в конфигурацию
        return Executors.newScheduledThreadPool(threadCount).also {
            it.threadFactory = Executors.defaultThreadFactory().apply {
                name = "scheduled-thread-pool-"
            }
        }
    }
}