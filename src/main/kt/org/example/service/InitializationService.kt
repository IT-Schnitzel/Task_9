package org.example.service

import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.ApplicationListener
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutorService

@Service
class InitializationService(
    private val fixedThreadPool: ExecutorService
) : ApplicationListener<ApplicationStartedEvent> {

    override fun onApplicationEvent(event: ApplicationStartedEvent) {
        scheduleDataInitialization()
    }

    @Scheduled(fixedRateString = "\${initialization.schedule.rate}")
    fun scheduleDataInitialization() {
        val categoryInit = CompletableFuture.runAsync(this::initializeCategories, fixedThreadPool)
        val locationInit = CompletableFuture.runAsync(this::initializeLocations, fixedThreadPool)
        CompletableFuture.allOf(categoryInit, locationInit).join()
    }

    private fun initializeCategories() {
        // Логика инициализации категорий
    }

    private fun initializeLocations() {
        // Логика инициализации локаций
    }
}