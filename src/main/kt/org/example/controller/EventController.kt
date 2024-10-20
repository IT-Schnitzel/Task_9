package org.example.controller

import org.example.model.Event
import org.example.service.EventService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture

@RestController
class EventController(private val eventService: EventService) {

    @GetMapping("/events")
    fun getEvents(
        @RequestParam budget: Double,
        @RequestParam currency: String,
        @RequestParam(required = false) dateFrom: String?,
        @RequestParam(required = false) dateTo: String?
    ): CompletableFuture<List<Event>> {
        return eventService.findEvents(budget, currency, dateFrom, dateTo)
    }
}