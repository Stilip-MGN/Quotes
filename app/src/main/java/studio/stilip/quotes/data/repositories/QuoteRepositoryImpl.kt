package studio.stilip.quotes.data.repositories

import io.reactivex.Single
import studio.stilip.quotes.data.api.RetrofitServiceQuote
import studio.stilip.quotes.data.dto.toDomain
import studio.stilip.quotes.domain.entities.Quote
import studio.stilip.quotes.domain.repository_interface.QuoteRepository
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val retrofitService: RetrofitServiceQuote
) : QuoteRepository {

    override fun getQuotesWithOffset(offset: Int): Single<List<Quote>> {
        return retrofitService.getQuotesWithOffset(offset.toString())
            .map { list -> list.map { q -> q.toDomain() } }
    }

    override fun getQuoteById(id: Int): Single<Quote> {
        return retrofitService.getQuoteById(id.toString())
    }
}