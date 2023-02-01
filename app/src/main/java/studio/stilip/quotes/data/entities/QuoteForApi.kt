package studio.stilip.quotes.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class QuoteForApi(
    val id: Int = 0,
    val createdBy: Int = 0,
    val text: String = "",
)
