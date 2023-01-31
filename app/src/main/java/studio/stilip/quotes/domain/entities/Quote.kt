package studio.stilip.quotes.domain.entities

data class Quote(
    val id: Int,
    val createdAt: String,
    val createdBy: String,
    val text: String,
    val tagList: List<String>,
    val colors: List<String>,
)
