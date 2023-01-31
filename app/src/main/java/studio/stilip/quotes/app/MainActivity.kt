package studio.stilip.quotes.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import studio.stilip.quotes.R
import studio.stilip.quotes.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel by viewModels<QuotesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = QuoteListAdapter {
            //TODO Обработать клик
        }

        viewModel.quotes.subscribe({ quotes ->
            adapter.submitList(quotes)
        }, {

        })


        with(binding) {
            recQuotes.adapter = adapter
        }
    }
}