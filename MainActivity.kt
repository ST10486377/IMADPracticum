package com.example.practicumexam10

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.practicumexam.DetailsActivity

class MainActivity : AppCompatActivity() {

    private val songTitles = ArrayList<String>()
    private val artistNames = ArrayList<String>()
    private val ratings = ArrayList<Int>()
    private val comments = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.btnAdd)
        val viewButton = findViewById<Button>(R.id.btnView)
        val exitButton = findViewById<Button>(R.id.btnExit)

        addButton.setOnClickListener {
            val titleInput = findViewById<EditText>(R.id.songTitle)
            val artistInput = findViewById<EditText>(R.id.artistName)
            val ratingInput = findViewById<EditText>(R.id.songRating)
            val commentInput = findViewById<EditText>(R.id.songComment)

            val title = titleInput.text.toString()
            val artist = artistInput.text.toString()
            val rating = ratingInput.text.toString().toIntOrNull()
            val comment = commentInput.text.toString()

            if (title.isEmpty() || artist.isEmpty() || rating == null || rating !in 1..5) {
                Toast.makeText(this, "Please enter valid data!", Toast.LENGTH_SHORT).show()
            } else {
                songTitles.add(title)
                artistNames.add(artist)
                ratings.add(rating)
                comments.add(comment)

                Toast.makeText(this, "Song added!", Toast.LENGTH_SHORT).show()

                // Clear inputs
                titleInput.text.clear()
                artistInput.text.clear()
                ratingInput.text.clear()
                commentInput.text.clear()
            }
        }

        viewButton.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putStringArrayListExtra("titles", songTitles)
            intent.putStringArrayListExtra("artists", artistNames)
            intent.putIntegerArrayListExtra("ratings", ratings)
            intent.putStringArrayListExtra("comments", comments)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finish()
        }
    }
}
