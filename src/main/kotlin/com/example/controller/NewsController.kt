package com.example.controller

import com.example.domain.News
import com.example.service.NewsService
import io.micronaut.http.annotation.*
import reactor.core.publisher.Mono
import java.util.*

@Controller("api/news")
class NewsController(private val newsService: NewsService) {

    @Get("/")
    fun getAllNews(): List<News> = newsService.findAll()

    @Get("/{id}")
    fun getNewsById(@PathVariable id: String): Mono<News> = newsService.findById(UUID.fromString(id))

    @Post("/")
    fun saveNews(@Body news: News): Mono<News> = newsService.save(news)

    @Put("/{id}")
    fun updateNews(@PathVariable id: String, @Body news: News): News = newsService.update(UUID.fromString(id), news)

    @Delete("/{id}")
    fun deleteNews(@PathVariable id: String): Mono<String>? = newsService.delete(UUID.fromString(id))
}