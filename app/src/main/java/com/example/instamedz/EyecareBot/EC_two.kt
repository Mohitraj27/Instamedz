package com.example.instamedz.EyecareBot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.instamedz.R
import com.example.instamedz.databinding.FragmentECTwoBinding


class EC_two : Fragment() {


    private lateinit var binding: FragmentECTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_e_c_two,
            container,
            false
        )
        binding.option1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_two_to_EC_three)
        }
        binding.option2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_two_to_EC_eight)
        }

        binding.option3.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_two_to_EC_nine)
        }
        return binding.root
    }

}