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
    var score=0;
    lateinit var currenQuestion: QnsAboveForty
    lateinit var answers:ArrayList<String>
    val maxNUmberOfQuestion =6
    var questions = arrayListOf<QnsAboveForty>(
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
        QnsAboveForty("Do you have watery eyes often?", arrayListOf("Yes", "Rarely", "Not at all"))

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
            Toast.makeText(activity,"Won", Toast.LENGTH_SHORT).show()
        }
        else{
            if(score>=3){
                Toast.makeText(activity,"Lost", Toast.LENGTH_SHORT).show()
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
        binding.aboveForty=this
        return binding.root
    }

}