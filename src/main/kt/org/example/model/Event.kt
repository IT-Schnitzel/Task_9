package org.example.model

data class Event(
    val id: Long,
    val name: String,
    val price: Double,
    val currency: String,
    val date: String
)