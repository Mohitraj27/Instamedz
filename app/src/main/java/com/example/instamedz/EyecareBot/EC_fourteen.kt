package com.example.instamedz.EyecareBot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.instamedz.R
import com.example.instamedz.databinding.FragmentECFourteenBinding


class EC_fourteen : Fragment() {

    private lateinit var binding: FragmentECFourteenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_e_c_fourteen,
            container,
            false
        )

        binding.option1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_fourteen_to_EC_sixteen)
        }
        binding.option2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_fourteen_to_EC_sixteen)
        }

        return binding.root
    }


}