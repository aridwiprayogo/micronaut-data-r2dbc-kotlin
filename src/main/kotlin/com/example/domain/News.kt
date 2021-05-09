package com.example.domain

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.GeneratedValue
import java.util.*

@MappedEntity
@Introspected
data class News(
    val title       : String = "",
    val body        : String = "",
    val description : String = "",
) {
    @field:Id
    @GeneratedValue
    var id: UUID? = null
}