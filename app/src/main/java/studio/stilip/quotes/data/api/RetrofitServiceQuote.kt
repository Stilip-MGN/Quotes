package studio.stilip.quotes.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import studio.stilip.quotes.data.entities.QuoteForApi
import studio.stilip.quotes.domain.entities.Quote

interface RetrofitServiceQuote {

    @GET("/test/?limit=10")
    fun getQuotesWithOffset(@Query("offset") offset: String): Single<List<QuoteForApi>>

    @GET("/test/{id_quote}")
    fun getQuoteById(@Path("id_quote") id_quote: String): Single<Quote>
}