package com.example.instamedz.EyecareBot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.instamedz.R
import com.example.instamedz.databinding.FragmentECWelcomeBinding

class EC_welcome : Fragment() {

    private lateinit var binding: FragmentECWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_e_c_welcome,
            container,
            false
        )
        binding.nextButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_welcome_to_EC_one)
        }
        return binding.root
    }


}