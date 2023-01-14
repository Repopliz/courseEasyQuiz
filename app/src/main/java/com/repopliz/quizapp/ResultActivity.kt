package com.repopliz.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.repopliz.quizapp.Constants.getQuestions

class ResultActivity : AppCompatActivity() {

    private var btnFinish: Button? = null
    private var tvYourScore: TextView? = null
    private var tvYourName: TextView? = null

    private var correctCount = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        initialiseViews()
        val yourName = intent.getStringExtra("yourName")
        correctCount = intent.getIntExtra("correctAnswers", -1)

        tvYourScore?.text = "Your score is $correctCount out of ${getQuestions().size}"
        tvYourName?.text = yourName

        btnFinish?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


    private fun initialiseViews() {
        btnFinish = findViewById(R.id.btnFinish)
        tvYourScore = findViewById(R.id.tvYourScore)
        tvYourName = findViewById(R.id.tvYourName)
    }
}