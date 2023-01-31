package studio.stilip.quotes.app.quote_detailing

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import studio.stilip.quotes.R
import studio.stilip.quotes.databinding.ActivityMainBinding
import studio.stilip.quotes.databinding.ActivityQuoteDetailingBinding

@AndroidEntryPoint
class QuoteDetailingActivity : AppCompatActivity(R.layout.activity_quote_detailing) {

    private val viewModel by viewModels<QuoteDetailingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityQuoteDetailingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val quoteId = intent.getIntExtra(EXTRA_QUOTE_ID, 0)

        viewModel.getQuote(quoteId)

        viewModel.quote.subscribe({ quote ->
            with(binding) {
                textQuote.text = quote.text
                date.text = quote.createdAt
            }
        }, {})
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    companion object {

        private const val EXTRA_QUOTE_ID = "extra_quote_id"

        fun createIntent(context: Context, quoteId: Int): Intent {
            return Intent(context, QuoteDetailingActivity::class.java).apply {
                putExtra(EXTRA_QUOTE_ID, quoteId)
            }
        }
    }
}