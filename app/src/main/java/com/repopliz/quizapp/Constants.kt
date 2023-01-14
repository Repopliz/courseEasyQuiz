package com.repopliz.quizapp

object Constants {

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina, "Argentina", "Uruguay",
            "Kiribati", "San Marino", 1
        )
        questionsList.add(que1)

        val que2 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia, "Philippines", "Marshal Islands",
            "Australia", "New Zealand", 3
        )
        questionsList.add(que2)

        val que3 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium, "Belgium", "France",
            "Romania", "Netherlands", 1
        )
        questionsList.add(que3)

        val que4 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil, "Senegal", "Grenada",
            "Jamaica", "Brazil", 4
        )
        questionsList.add(que4)

        val que5 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark, "Belgium", "Denmark",
            "Australia", "San Marino", 2
        )
        questionsList.add(que5)

        val que6 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji, "New Zealand", "Fiji",
            "Marshall Islands", "Faroe Islands", 2
        )
        questionsList.add(que6)

        val que7 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany, "Germany", "Austria",
            "Netherlands", "Switzerland", 1
        )
        questionsList.add(que7)

        val que8 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india, "Sri Lanka", "Iran",
            "Pakistan", "India", 4
        )
        questionsList.add(que8)

        val que9 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait, "Republic of Congo", "Nicaragua",
            "Kuwait", "Namibia", 3
        )
        questionsList.add(que9)

        val que10 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand, "Australia", "Papua New Guinea",
            "Tuvalu", "New Zealand", 4
        )
        questionsList.add(que10)

        return questionsList
    }
}