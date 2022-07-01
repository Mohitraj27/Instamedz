package com.example.instamedz.EyecareBot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.instamedz.R
import com.example.instamedz.databinding.FragmentECSixBinding

class EC_six : Fragment() {


private lateinit var binding: FragmentECSixBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_e_c_six,
            container,
            false
        )
        binding.option1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_six_to_EC_seven)
        }
        return binding.root
    }


}