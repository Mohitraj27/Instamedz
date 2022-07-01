package com.example.instamedz.EyecareBot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.instamedz.R
import com.example.instamedz.databinding.FragmentECElevenBinding


class EC_eleven : Fragment() {

private lateinit var binding:FragmentECElevenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_e_c_eleven,
            container,
            false
        )
        binding.option1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_eleven_to_EC_twelve)
        }
        binding.option2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_eleven_to_EC_twelve)
        }
        return binding.root
    }


}