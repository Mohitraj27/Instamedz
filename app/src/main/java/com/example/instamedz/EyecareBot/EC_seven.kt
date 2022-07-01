package com.example.instamedz.EyecareBot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.instamedz.R
import com.example.instamedz.databinding.FragmentECSevenBinding


class EC_seven : Fragment() {

private lateinit var binding:FragmentECSevenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_e_c_seven,
            container,
            false
        )
        binding.option1.setOnClickListener {
            //TODO: Eye exercise
        }
        return binding.root
    }


    }
