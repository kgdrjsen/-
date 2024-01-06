package com.android.apptest6recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.apptest6recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.sample_1,"Bella","1"))
        dataList.add(MyItem(R.drawable.sample_2,"Charlie","2"))
        dataList.add(MyItem(R.drawable.sample_3,"Daisy","3"))
        dataList.add(MyItem(R.drawable.sample_4,"Duke","1"))
        dataList.add(MyItem(R.drawable.sample_5,"Max","4"))
        dataList.add(MyItem(R.drawable.sample_6,"Happy","5"))
        dataList.add(MyItem(R.drawable.sample_7,"Luna","3"))
        dataList.add(MyItem(R.drawable.sample_8,"Bob","2"))
        dataList.add(MyItem(R.drawable.sample_1,"B","1"))
        dataList.add(MyItem(R.drawable.sample_2,"C","2"))
        dataList.add(MyItem(R.drawable.sample_3,"D","3"))
        dataList.add(MyItem(R.drawable.sample_4,"D","1"))
        dataList.add(MyItem(R.drawable.sample_5,"H","4"))
        dataList.add(MyItem(R.drawable.sample_6,"L","5"))
        dataList.add(MyItem(R.drawable.sample_7,"T","3"))
        dataList.add(MyItem(R.drawable.sample_8,"B","2"))

        binding.recyclerview.adapter = MyAdapter(dataList)

        val adapter = MyAdapter(dataList)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : MyAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val name : String = dataList[position].aName
                Toast.makeText(this@MainActivity,"$name 선택",Toast.LENGTH_SHORT).show()
            }
        }


    }
}