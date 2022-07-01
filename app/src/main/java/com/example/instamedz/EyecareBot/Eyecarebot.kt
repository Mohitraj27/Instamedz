package com.example.instamedz.EyecareBot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.instamedz.R
import com.example.instamedz.databinding.EyecareBotBinding
import kotlinx.android.synthetic.main.activity_login.*

class Eyecarebot : AppCompatActivity() {
    private lateinit var binding: EyecareBotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.eyecare_bot)
    }
}