package studio.stilip.quotes.data.repositories

import io.reactivex.Single
import studio.stilip.quotes.domain.entities.Quote
import studio.stilip.quotes.domain.repository_interface.QuoteRepository
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor() : QuoteRepository {

    val fake = listOf(
        Quote(
            1, "", 0, "Честно говоря, моя дорогая, мне наплевать", emptyList(), emptyList()
        ),
        Quote(
            2, "2019-03-11", 1, "Я собираюсь сделать ему предложение, от которого он не сможет отказаться",
            listOf(
                "android", "iOS", "MacOS", "Ubuntu", "Centos", "Solaris", "Windows", "IpadOS"
            ),
            listOf(
                "YELLOW", "CYAN", "LTGRAY"
            )
        ),
        Quote(
            1, "", 1, "Честно говоря, моя дорогая, мне наплевать", emptyList(), emptyList()
        ),
        Quote(
            2, "", 0, "Я собираюсь сделать ему предложение, от которого он не сможет отказаться", emptyList(), emptyList()
        ),
        Quote(
            1, "", 0, "Честно говоря, моя дорогая, мне наплевать", emptyList(), emptyList()
        ),
        Quote(
            2, "", 0, "Я собираюсь сделать ему предложение, от которого он не сможет отказаться", emptyList(), emptyList()
        ),
        Quote(
            1, "", 1, "Честно говоря, моя дорогая, мне наплевать", emptyList(), emptyList()
        ),
    )

    override fun getQuotesWithOffset(offset: Int): Single<List<Quote>> {
        return Single.just(fake)
    }

    override fun getQuoteById(id: Int): Single<Quote> {
        return Single.just(fake.first { quote -> quote.id == id })
    }
}