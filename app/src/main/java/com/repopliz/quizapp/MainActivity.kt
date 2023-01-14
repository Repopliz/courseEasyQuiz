package com.repopliz.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val nameET: EditText = findViewById(R.id.nameET)
        val startButton: Button = findViewById(R.id.startButton)
        startButton.setOnClickListener {

            if (nameET.text.isNotEmpty()) {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra("yourName", nameET.text.toString())
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            }

        }

    }
}