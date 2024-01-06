package com.android.apptest6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.apptest6.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding : ActivityMain4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //ImageAdapter 객체를 생성하고 GridView 객체에 연결
        binding.imgsGridview.adapter = ImageAdapter()
        //
        binding.imgsGridview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,""+(position+1)+"번쨰 선택",Toast.LENGTH_SHORT).show()
            //아래가 더 정확한 주소인거 같음
//            Toast.makeText(this@MainActivity4,""+(position+1)+"번쨰 선택",Toast.LENGTH_SHORT).show()
        }

    }
}