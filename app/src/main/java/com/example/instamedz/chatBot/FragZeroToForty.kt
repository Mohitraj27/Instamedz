package com.example.instamedz.chatBot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.instamedz.R
import com.example.instamedz.databinding.FragmentFragZeroToFortyBinding


class FragZeroToForty : Fragment() {

    lateinit var binding: FragmentFragZeroToFortyBinding
    lateinit var currenQuestion: QnsZeroToForty
    private var questionIndex = 0
    var score = 0;
    val maxNUmberOfQuestion = 21
    lateinit var answers: ArrayList<String>
    lateinit var selectedAnswer: String

    private var questions = arrayListOf<QnsZeroToForty>(
        QnsZeroToForty(
            "Do you feel difficulty in reading when something is written on board? ",
            arrayListOf("Yes", "Rarely", "Not at all")
        ),
        QnsZeroToForty(
            "Do you feel lost or unconcentrated in your studies? ",
            arrayListOf("Yes", "Rarely", "Not at all")
        ),
        QnsZeroToForty(
            "How much time do you spend under sunlight? ",
            arrayListOf("Yes", "Rarely", "Not at all")
        ),
        QnsZeroToForty("Are you on a regular diet?", arrayListOf("Yes", "Rarely", "Not at all")),
        QnsZeroToForty(
            "Do you experience difficulty in reading?",
            arrayListOf("Yes", "Rarely", "Not at all")
        ),
        QnsZeroToForty("Do you have watery eyes often?", arrayListOf("Yes", "Rarely", "Not at all")),

                QnsZeroToForty("What is your occupation?", arrayListOf("Primary sector", "Industrial Sector", "Others")),

                        QnsZeroToForty("Do you have any of these diseases?", arrayListOf("Diabetes", "Hypertension", "None")),

                                QnsZeroToForty("Did you have an eye infection/eye disease in the past?", arrayListOf("Contracts", "Astigmatism", "Others")),


        QnsZeroToForty("Is there anyone who has a history of eye disease?", arrayListOf("Mother", "Father", "Siblings")),
        QnsZeroToForty("How long do you spend your time at your workplace?", arrayListOf("3 hours", "6 hours", "More than 6 hours")),
                QnsZeroToForty("How much is your screen time?", arrayListOf("4 hours", "6 hours", "More than 6 hours")),
        QnsZeroToForty("Do you face difficulty driving a car?", arrayListOf("Yes","No")),
                QnsZeroToForty("Do you experience headaches ?", arrayListOf("Yes", "Rarely", "Not at all")),
    QnsZeroToForty("Do you hold the objects close to your face to see them clearly?", arrayListOf("Yes", "Rarely", "Not at all")),
    QnsZeroToForty("Do you experience itching?", arrayListOf("Yes", "Rarely", "Not at all")),
    QnsZeroToForty("How many hours do you sleep?", arrayListOf("Less than 5 hours", "5-8 hours", "More than 8 hours")),
    QnsZeroToForty("Do you blink your eyes often while you are trying to see distant objects?", arrayListOf("Yes", "Rarely", "Not at all")),
    QnsZeroToForty("Do you rub your eyes?", arrayListOf("Yes", "Rarely", "Not at all")),
    QnsZeroToForty("Have you used any glasses before?", arrayListOf("Yes ", "No","Sorry, I Don't remember")),
    QnsZeroToForty("If yes then when did you change your glasses last ?", arrayListOf("Recently", "Been a while","Sorry, I Don't remember"))




    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun checkAns(answer: String) {
        if (answer.equals(currenQuestion.theAns[0])) {
            score += 2
        } else if (answer.equals(currenQuestion.theAns[1])) {
            score += 1
        } else
            score += 0

        questionIndex++

        if (questionIndex < maxNUmberOfQuestion) {
            setQuestion()
            binding.invalidateAll()
        } else {
            getScore()
        }

    }

    private fun getScore() {
        if (score >= 15) {
            Toast.makeText(activity, "Based on our observation, We'll suggest you a convex/concave lens.", Toast.LENGTH_SHORT).show()
        } else {
            if (score < 15) {
                Toast.makeText(activity, "Based on our observation, We'll suggest you a sunglasses or blue lens", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun setQuestion() {
        currenQuestion = questions[questionIndex]
        answers = ArrayList(currenQuestion.theAns)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_frag_zero_to_forty,
            container,
            false
        )
        setQuestion()
        binding.zerotoforty=this
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)
        binding.option1.setOnClickListener {
            checkAns(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener {
            checkAns(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener {
            checkAns(binding.option3.text.toString())
        }
    }

}