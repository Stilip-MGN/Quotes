package studio.stilip.quotes.app.main_page

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import studio.stilip.quotes.domain.entities.Quote
import studio.stilip.quotes.domain.usecase.GetQuotesWithOffsetUseCase
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(
    private val getQuotesWithOffset: GetQuotesWithOffsetUseCase
) : ViewModel() {

    val quotes = BehaviorSubject.create<List<Quote>>().also { getQuotes(1) }

    fun getQuotes(offset: Int) {
        getQuotesWithOffset(offset)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list ->
                val old = quotes.value ?: emptyList()
                val res: List<Quote> = old.plus(list)
                quotes.onNext(res)
            }, {
                println(it.message)
            })
    }

}