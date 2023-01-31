package studio.stilip.quotes.app

import androidx.recyclerview.widget.RecyclerView
import studio.stilip.quotes.databinding.CardQuoteBinding
import studio.stilip.quotes.domain.entities.Quote

class QuoteListViewHolder(
    private val binding: CardQuoteBinding,
    private val onItemClicked: (Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var quote: Quote

    init {
        itemView.setOnClickListener {
            onItemClicked(quote.id)
        }
    }

    fun bind(item: Quote) = with(binding) {
        quote = item

        textQuote.text = quote.text
    }
}