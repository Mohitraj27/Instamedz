package com.example.instamedz.chatBot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.instamedz.R
import com.example.instamedz.databinding.FragmentQuestionBinding


class QuestionFragment : Fragment() {

lateinit var binding:FragmentQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false) // Inflate the layout for this fragment
        binding.option1.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_questionFragment_to_fragZeroToForty)
        }
        binding.option2.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_questionFragment_to_fragZeroToForty)
        }
        binding.option3.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_questionFragment_to_fragAboveForty)
        }
        return binding.root
    }


}