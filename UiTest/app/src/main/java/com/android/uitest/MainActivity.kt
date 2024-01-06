package com.android.uitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 : Button = findViewById(R.id.btn_login)
        val btn2 : Button = findViewById(R.id.btn_logout)
        btn2.visibility = View.INVISIBLE

        btn1.setOnClickListener {
            btn1.visibility = View.INVISIBLE
            btn2.visibility = View.VISIBLE
        }

        btn2.setOnClickListener {
            btn1.visibility = View.VISIBLE
            btn2.visibility = View.INVISIBLE
        }


    }
}