package studio.stilip.quotes.data.dto

import studio.stilip.quotes.data.entities.QuoteForApi
import studio.stilip.quotes.domain.entities.Quote

fun QuoteForApi.toDomain(): Quote =
    Quote(
        id = this.id,
        createdAt = "",
        createdBy = this.createdBy,
        text = this.text,
        tagList = emptyList(),
        colors = emptyList(),
    )