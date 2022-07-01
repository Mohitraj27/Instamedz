package com.example.instamedz.chatBot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.instamedz.R
import com.example.instamedz.databinding.FragmentFragAboveFortyBinding
import com.example.instamedz.chatBot.QnsAboveForty

class FragAboveForty : Fragment() {
    lateinit var binding: FragmentFragAboveFortyBinding
    lateinit var selectedAnswer:String
    private var questionIndex = 0
    var score=0
    lateinit var currenQuestion: QnsAboveForty
    lateinit var answers:ArrayList<String>
    val maxNUmberOfQuestion =21

    private var questions = arrayListOf<QnsAboveForty>(
        QnsAboveForty(
            "Do you have sudden flashes of light? ",
            arrayListOf("Yes", "Rarely", "Not at all")
        ),
        QnsAboveForty(
            "Do you experience sudden loss of vision in one eye? ",
            arrayListOf("Yes", "Rarely", "Not at all")
        ),
        QnsAboveForty(
            "Do you spot halos around light? ",
            arrayListOf("Yes", "Rarely", "Not at all")
        ),
        QnsAboveForty("Are you on a regular diet?", arrayListOf("Yes", "Rarely", "Not at all")),
        QnsAboveForty(
            "Do you have double visions?",
            arrayListOf("Yes", "Rarely", "Not at all")
        ),
        QnsAboveForty("Do you have watery eyes often?", arrayListOf("Yes", "Rarely", "Not at all")),

                QnsAboveForty("What is your occupation?", arrayListOf("Primary sector", "Industrial Sector", "Others")),

    QnsAboveForty("Do you have any of these diseases?", arrayListOf("Diabetes", "Hypertension", "None")),

    QnsAboveForty("Did you have an eye infection/eye disease in the past?", arrayListOf("Contracts", "Astigmatism", "Others")),


    QnsAboveForty("Is there anyone who has a history of eye disease?", arrayListOf("Mother", "Father", "Siblings")),
    QnsAboveForty("How long do you spend your time at your workplace?", arrayListOf("3 hours", "6 hours", "More than 6 hours")),
    QnsAboveForty("How much is your screen time?", arrayListOf("4 hours", "6 hours", "More than 6 hours")),
    QnsAboveForty("Do you face difficulty driving a car?", arrayListOf("Yes","No")),
    QnsAboveForty("Do you experience headaches ?", arrayListOf("Yes", "Rarely", "Not at all")),
    QnsAboveForty("Do you hold the objects close to your face to see them clearly?", arrayListOf("Yes", "Rarely", "Not at all")),
    QnsAboveForty("Do you experience itching?", arrayListOf("Yes", "Rarely", "Not at all")),
    QnsAboveForty("How many hours do you sleep?", arrayListOf("Less than 5 hours", "5-8 hours", "More than 8 hours")),
    QnsAboveForty("Do you blink your eyes often while you are trying to see distant objects?", arrayListOf("Yes", "Rarely", "Not at all")),
    QnsAboveForty("Do you rub your eyes?", arrayListOf("Yes", "Rarely", "Not at all")),
    QnsAboveForty("Have you used any glasses before?", arrayListOf("Yes ", "No","Sorry, I Don't remember")),
    QnsAboveForty("If yes then when did you change your glasses last ?", arrayListOf("Recently", "Been a while","Sorry, I Don't remember"))




    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private fun checkAns(answer:String){
        if(answer.equals(currenQuestion.theAns[0])){
            score+=2
        }
        else if( answer.equals(currenQuestion.theAns[1])){
            score+=1
        }
        else
            score+=0

        questionIndex++

        if(questionIndex<maxNUmberOfQuestion){
            setQuestion()
            binding.invalidateAll()
        }
        else{
            getScore()
        }

    }

    private fun getScore(){
        if(score>=3){
            Toast.makeText(activity,"Based on our observation, We'll suggest you a convex/concave lens.", Toast.LENGTH_LONG).show()
        }
        else{
            if(score>=3){
                Toast.makeText(activity,"Based on our observation, We'll suggest you a sunglasses or blue lens", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun setQuestion(){
        currenQuestion =questions[questionIndex]
        answers = ArrayList(currenQuestion.theAns)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_frag_above_forty,
            container,
            false
        )
        setQuestion()
        binding.aboveForty=this
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
