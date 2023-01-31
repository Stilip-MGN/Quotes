package studio.stilip.quotes.app.quote_detailing

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import studio.stilip.quotes.R
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
                val tags = quote.tagList
                val colors = quote.colors
                var i = 0

                for (tag in tags) {
                    val chip = Chip(this@QuoteDetailingActivity)
                    chip.text = tag
                    if (i < colors.count()) {
                        val color = getColorFromText(colors[i])
                        chip.setTextColor(color)
                    }

                    groupTags.addView(chip)
                    i += 1
                }
            }
        }, {})
    }

    private fun getColorFromText(colorName: String): Int {
        return when (colorName) {
            "BLACK" -> Color.BLACK
            "BLUE" -> Color.BLUE
            "CYAN" -> Color.CYAN
            "DKGRAY" -> Color.DKGRAY
            "GRAY" -> Color.GRAY
            "LTGRAY" -> Color.LTGRAY
            "MAGENTA" -> Color.MAGENTA
            "RED" -> Color.RED
            "TRANSPARENT" -> Color.TRANSPARENT
            "WHITE" -> Color.WHITE
            "YELLOW" -> Color.YELLOW
            else -> Color.GREEN
        }
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