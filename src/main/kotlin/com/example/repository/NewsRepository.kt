package com.example.repository

import com.example.domain.News
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.r2dbc.annotation.R2dbcRepository
import io.micronaut.data.r2dbc.repository.ReactorCrudRepository
import java.util.*

@R2dbcRepository(dialect = Dialect.POSTGRES)
interface NewsRepository : ReactorCrudRepository<News, UUID> {

}