package studio.stilip.quotes.app

import androidx.recyclerview.widget.DiffUtil
import studio.stilip.quotes.domain.entities.Quote

object QuoteDiffCallback : DiffUtil.ItemCallback<Quote>() {

    override fun areItemsTheSame(oldItem: Quote, newItem: Quote) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Quote, newItem: Quote) =
        oldItem == newItem
}