package com.example.instamedz.EyecareBot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.instamedz.R
import com.example.instamedz.databinding.FragmentECThreeBinding


class EC_three : Fragment() {

  private lateinit var binding: FragmentECThreeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_e_c_three,
            container,
            false
        )

        binding.option1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_three_to_EC_four)
        }
        binding.option2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_three_to_EC_four)
        }

        binding.option3.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_three_to_EC_four)
        }
        return binding.root}


}