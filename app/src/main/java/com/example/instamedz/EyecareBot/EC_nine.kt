package com.example.instamedz.EyecareBot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.instamedz.R
import com.example.instamedz.databinding.FragmentECNineBinding


class EC_nine : Fragment() {
private lateinit var binding:FragmentECNineBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_e_c_nine,
            container,
            false
        )

        binding.yes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_nine_to_EC_ten)
        }
        binding.no.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_nine_to_EC_eleven)
        }

        return binding.root
    }


}