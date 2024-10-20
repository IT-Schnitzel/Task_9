package org.example.controller

import org.example.service.NewsWorker
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NewsController(private val newsWorker: NewsWorker) {

    @PostMapping("/news/start")
    fun startNewsProcessing() {
        newsWorker.start()
    }
}