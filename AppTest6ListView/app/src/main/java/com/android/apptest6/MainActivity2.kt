package com.android.apptest6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.android.apptest6.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    //변하지 않는 뷰 바인딩이면 가능할 수도? 대신 이렇게 하면 밑에 다시 binding = ... 여기가 없어도 됨.
    private val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
//    private lateinit var biding : ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        biding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //데이터 원본
        val items = arrayOf<String?>("item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item5", "item6", "item7", "item8", "item5", "item6", "item7", "item8", "item5", "item6",  "item7", "item8")
        //어댑터
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,items)

        binding.listView.adapter = adapter
    }
}