package org.example.service

import kotlinx.coroutines.*
import org.springframework.stereotype.Service

@Service
class NewsWorker {

    fun start() {
        val dispatcher = newFixedThreadPoolContext(4, "news-pool")
        CoroutineScope(dispatcher).launch {
            // Запуск worker'ов для получения новостей
            repeat(10) {
                launch { getNewsAndProcess() }
            }
        }
    }
    private suspend fun getNewsAndProcess() {
        // Логика получения новостей
        // Запись данных в канал
    }
}