package org.example.processor

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

class NewsProcessor {

    private val channel = Channel<String>()

    fun startProcessing() {
        GlobalScope.launch {
            for (news in channel) {
                // Логика обработки новостей
            }
        }
    }

    fun sendNews(news: String) {
        runBlocking {
            channel.send(news)
        }
    }
}