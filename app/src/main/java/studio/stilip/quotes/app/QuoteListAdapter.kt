package studio.stilip.quotes.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import studio.stilip.quotes.databinding.CardQuoteBinding
import studio.stilip.quotes.domain.entities.Quote

class QuoteListAdapter(
    private val onItemClicked: (Int) -> Unit,
) : ListAdapter<Quote, QuoteListViewHolder>(QuoteDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        QuoteListViewHolder(
            CardQuoteBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClicked,
        )

    override fun onBindViewHolder(holder: QuoteListViewHolder, position: Int) =
        holder.bind(getItem(position))
}