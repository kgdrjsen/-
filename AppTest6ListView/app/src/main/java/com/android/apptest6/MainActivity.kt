package com.android.apptest6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.apptest6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        binding.myButton.setOnClickListener {
            binding.myTextView.text = "바인딩이 잘 되었네요~~"
        }
    }
}