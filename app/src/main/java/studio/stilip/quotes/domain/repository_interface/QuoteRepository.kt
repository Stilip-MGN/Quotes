package studio.stilip.quotes.domain.repository_interface

import io.reactivex.Single
import studio.stilip.quotes.domain.entities.Quote

interface QuoteRepository {

    fun getQuotesWithOffset(offset: Int): Single<List<Quote>>
}