package studio.stilip.quotes.domain.usecase

import studio.stilip.quotes.domain.repository_interface.QuoteRepository
import javax.inject.Inject

class GetQuotesWithOffsetUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    operator fun invoke(offset: Int) = repository.getQuotesWithOffset(offset)
}