package studio.stilip.quotes.app.quote_detailing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import studio.stilip.quotes.R
import studio.stilip.quotes.databinding.ActivityMainBinding

@AndroidEntryPoint
class QuoteDetailingActivity : AppCompatActivity(R.layout.activity_quote_detailing) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}