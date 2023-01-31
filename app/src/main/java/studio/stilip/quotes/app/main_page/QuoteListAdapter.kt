package studio.stilip.quotes.app.main_page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import studio.stilip.quotes.databinding.CardQuoteBinding
import studio.stilip.quotes.databinding.CardQuoteUserBinding
import studio.stilip.quotes.domain.entities.Quote

class QuoteListAdapter(
    private val onItemClicked: (Int) -> Unit,
) : ListAdapter<Quote, RecyclerView.ViewHolder>(QuoteDiffCallback) {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).createdBy) {
            0 -> 0
            else -> 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> QuoteListViewHolder(
                CardQuoteBinding.inflate(LayoutInflater.from(parent.context), parent, false),
                onItemClicked,
            )
            else -> QuoteUserListViewHolder(
                CardQuoteUserBinding.inflate(LayoutInflater.from(parent.context), parent, false),
                onItemClicked,
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            1 -> (holder as QuoteListViewHolder).bind(getItem(position))
            else -> (holder as QuoteUserListViewHolder).bind(getItem(position))
        }
    }
}