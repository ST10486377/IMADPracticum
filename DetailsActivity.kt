package com.example.practicumexam

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.practicumexam10.R

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val listView = findViewById<ListView>(R.id.songListView)
        val avgRatingText = findViewById<TextView>(R.id.txtAverage)
        val backButton = findViewById<Button>(R.id.btnBack)

        val titles = intent.getStringArrayListExtra("titles") ?: arrayListOf()
        val artists = intent.getStringArrayListExtra("artists") ?: arrayListOf()
        val ratings = intent.getIntegerArrayListExtra("ratings") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        val details = ArrayList<String>()
        for (i in titles.indices) {
            details.add("🎵 ${titles[i]} by ${artists[i]} (Rating: ${ratings[i]})\n💬 ${comments[i]}")
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, details)
        listView.adapter = adapter

        val avgRating = if (ratings.isNotEmpty()) ratings.sum().toDouble() / ratings.size else 0.0
        avgRatingText.text = "⭐ Average Rating: %.2f".format(avgRating)

        backButton.setOnClickListener {
            finish()
        }
    }
}
