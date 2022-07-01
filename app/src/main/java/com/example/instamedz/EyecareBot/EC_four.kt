package com.example.instamedz.EyecareBot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.instamedz.R
import com.example.instamedz.databinding.FragmentECFourBinding

class EC_four : Fragment() {


private lateinit var binding:FragmentECFourBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_e_c_four,
            container,
            false
        )

        binding.option1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_EC_four_to_EC_five)
        }
        binding.option2.setOnClickListener {
          //TODO: Diet Chart
        }

        return binding.root
    }


}