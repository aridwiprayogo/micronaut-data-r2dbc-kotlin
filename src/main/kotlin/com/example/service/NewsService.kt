package com.example.service

import com.example.domain.News
import reactor.core.publisher.Mono
import java.util.*

interface NewsService {
    fun findAll(): List<News>
    fun findById(id: UUID): Mono<News>
    fun save(news: News): Mono<News>
    fun update(id: UUID, news: News): News
    fun delete(id: UUID): Mono<String>?
}
