package studio.stilip.quotes.domain.entities

data class Quote(
    val id: Int,
    val createdAt: String,
    val createdBy: Int,
    val text: String,
    val tagList: List<String>,
    val colors: List<String>,
)