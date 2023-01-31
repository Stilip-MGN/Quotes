package studio.stilip.quotes.app

import androidx.recyclerview.widget.RecyclerView
import studio.stilip.quotes.databinding.CardQuoteUserBinding
import studio.stilip.quotes.domain.entities.Quote

class QuoteUserListViewHolder(
    private val binding: CardQuoteUserBinding,
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