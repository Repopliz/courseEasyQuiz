package com.repopliz.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var lockChoices = false
    private var hasChoice = false
    private var finished = false
    private var wrongAnswers = 0

    private var yourName = "false"

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var imageView: ImageView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null

    private var buttonSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        initViews()
        yourName = intent.getStringExtra("yourName").toString()
        Log.i("SEARCHMEEEE", yourName.toString())

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        buttonSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()
        setQuestion()
    }

    private fun setQuestion() {
        defaultOptionView()
        lockChoices = false

        //mCurrentPosition = 1
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        imageView?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if (mCurrentPosition == mQuestionsList!!.size) {
            buttonSubmit?.text = "FINISH"
            finished = true
        } else {
            buttonSubmit?.text = "SUBMIT"
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvOptionOne -> {
                if (lockChoices) {
                    return
                }
                // selectedOptionView(tvOptionOne, 1) but it's nullable so I write it like this
                tvOptionOne?.let { selectedOptionView(it, 1) }
            }
            R.id.tvOptionTwo -> {
                if (lockChoices) {
                    return
                }
                tvOptionTwo?.let { selectedOptionView(it, 2) }
            }
            R.id.tvOptionThree -> {
                if (lockChoices) {
                    return
                }
                tvOptionThree?.let { selectedOptionView(it, 3) }
            }
            R.id.tvOptionFour -> {
                if (lockChoices) {
                    return
                }
                tvOptionFour?.let { selectedOptionView(it, 4) }
            }
            R.id.buttonSubmit -> {
                if (mSelectedOptionPosition == 0 && hasChoice) {
                    mCurrentPosition++
                    if (mCurrentPosition <= mQuestionsList!!.size) {
                        setQuestion()
                    } else {
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra("correctAnswers", mQuestionsList!!.size - wrongAnswers)
                        intent.putExtra("yourName", yourName)
                        startActivity(intent)
                        finish()
                    }
                } else if (mSelectedOptionPosition == 0 && !hasChoice) {
                    Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_answer_border_bg)
                        wrongAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_answer_border_bg)
                    lockChoices = true
                    if (finished) {
                        buttonSubmit?.text = "GO TO RESULTS"
                    } else {
                        buttonSubmit?.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
        hasChoice = false
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {
        defaultOptionView()

        mSelectedOptionPosition = selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(Typeface.DEFAULT_BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
        hasChoice = true
    }


    private fun initViews() {
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tvQuestion)
        imageView = findViewById(R.id.imageView)
        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)
        buttonSubmit = findViewById(R.id.buttonSubmit)
    }

    private fun answerView(answer: Int, drawable: Int) {
        when (answer) {
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(this, drawable)
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(this, drawable)
            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(this, drawable)
            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(this, drawable)
            }
        }
    }

}