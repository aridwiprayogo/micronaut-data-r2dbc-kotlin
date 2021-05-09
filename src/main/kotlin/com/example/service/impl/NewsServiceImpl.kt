package com.example.service.impl

import com.example.domain.News
import com.example.repository.NewsRepository
import com.example.service.NewsService
import io.micronaut.transaction.annotation.ReadOnly
import reactor.core.publisher.Mono
import java.util.*
import javax.inject.Singleton
import java.lang.Exception
import javax.transaction.Transactional

@Singleton
open class NewsServiceImpl(private val repository: NewsRepository) : NewsService {

    @ReadOnly
    override fun findAll(): List<News> =
        repository.findAll().toIterable().toList()

    @ReadOnly
    override fun findById(id: UUID): Mono<News> =
        repository.findById(id)

    @Transactional
    override fun save(news: News): Mono<News> =
        repository.save(news)

    @Transactional
    override fun update(id: UUID, news: News): News {
        return repository.findById(id).toFuture().get().copy(
            title = news.title,
            body = news.body,
            description = news.description
        ).let {
            repository.update(it).block()
        } ?: throw Exception() 
    }

    @Transactional
    override fun delete(id: UUID) : Mono<String>? {
        return repository.findById(id).map {
            val deleteById = it.id?.let { it1 -> repository.deleteById(it1) }
            "data ${deleteById?.block()} successfully deleted"
        }
    }
}
