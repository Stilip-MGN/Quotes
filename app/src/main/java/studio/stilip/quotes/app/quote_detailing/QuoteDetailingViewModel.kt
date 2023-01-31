package studio.stilip.quotes.app.quote_detailing

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import studio.stilip.quotes.domain.entities.Quote
import studio.stilip.quotes.domain.usecase.GetQuoteByIdUseCase
import javax.inject.Inject

@HiltViewModel
class QuoteDetailingViewModel @Inject constructor(
    private val getQuoteByIdUse: GetQuoteByIdUseCase
) : ViewModel() {

    val quote = BehaviorSubject.create<Quote>()

    fun getQuote(id: Int) {
        getQuoteByIdUse(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ quote ->
                this.quote.onNext(quote)
            }, {
                println(it.message)
            })
    }

}