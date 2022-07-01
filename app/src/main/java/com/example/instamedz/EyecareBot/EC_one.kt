package com.example.instamedz.EyecareBot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.instamedz.R
import com.example.instamedz.databinding.FragmentECOneBinding


class EC_one : Fragment() {

    private lateinit var binding: FragmentECOneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_e_c_one,
            container,
            false
        )

        binding.option1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_one_to_EC_two)
        }
        binding.option2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_one_to_EC_two)
        }

        binding.option3.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_one_to_EC_thirteen)
        }
        return binding.root
    }


}