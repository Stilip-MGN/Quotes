package studio.stilip.quotes.domain.usecase

import studio.stilip.quotes.domain.repository_interface.QuoteRepository
import javax.inject.Inject

class GetQuoteByIdUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    operator fun invoke(id: Int) = repository.getQuoteById(id)
}