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


        val dataList = mutableListOf<Items>() .apply {
            add(Items.MyTitle("1"))
            add(Items.MyItem(R.drawable.sample_3,"Duke","1"))
            add(Items.MyItem(R.drawable.sample_6,"Luna","1"))
            add(Items.MyItem(R.drawable.sample_8,"Merry","1"))
            add(Items.MyItem(R.drawable.sample_6,"Mung","1"))
            add(Items.MyTitle("2"))
            add(Items.MyItem(R.drawable.sample_1,"Charlie","2"))
            add(Items.MyItem(R.drawable.sample_4,"Max","2"))
            add(Items.MyItem(R.drawable.sample_7,"Bob","2"))
            add(Items.MyItem(R.drawable.sample_11,"Sara","2"))
            add(Items.MyItem(R.drawable.sample_10,"Ganga","2"))
            add(Items.MyTitle("3"))
            add(Items.MyItem(R.drawable.sample_5,"Happy","3"))
            add(Items.MyItem(R.drawable.sample_0,"Bella","3"))
            add(Items.MyTitle("4"))
            add(Items.MyItem(R.drawable.sample_2,"Daisy","4"))
            add(Items.MyItem(R.drawable.sample_9,"Jisoo","4"))
            add(Items.MyItem(R.drawable.sample_12,"Ddong","4"))
        }

//        val dataList = mutableListOf<MyItem>()
//        dataList.add(MyItem((R.drawable.sample_1,"Bella","1")))
//        dataList.add(MyItem(R.drawable.sample_2,"Charlie","2"))
//        dataList.add(MyItem(R.drawable.sample_3,"Daisy","3"))
//        dataList.add(MyItem(R.drawable.sample_4,"Duke","1"))
//        dataList.add(MyItem(R.drawable.sample_5,"Max","4"))
//        dataList.add(MyItem(R.drawable.sample_6,"Happy","5"))
//        dataList.add(MyItem(R.drawable.sample_7,"Luna","3"))
//        dataList.add(MyItem(R.drawable.sample_8,"Bob","2"))
//        dataList.add(MyItem(R.drawable.sample_1,"B","1"))
//        dataList.add(MyItem(R.drawable.sample_2,"C","2"))
//        dataList.add(MyItem(R.drawable.sample_3,"D","3"))
//        dataList.add(MyItem(R.drawable.sample_4,"D","1"))
//        dataList.add(MyItem(R.drawable.sample_5,"H","4"))
//        dataList.add(MyItem(R.drawable.sample_6,"L","5"))
//        dataList.add(MyItem(R.drawable.sample_7,"T","3"))
//        dataList.add(MyItem(R.drawable.sample_8,"B","2"))

        binding.recyclerview.adapter = MyAdapter(dataList)

        val adapter = MyAdapter(dataList)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)



        adapter.itemClick = object : MyAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val name : String = (dataList[position] as Items.MyItem).aName
//                val name : String = dataList[position].aName
                Toast.makeText(this@MainActivity,"$name 선택",Toast.LENGTH_SHORT).show()
            }
        }

        binding.recyclerview.addItemDecoration(
            HeaderItemDecoration(
                recyclerView = binding.recyclerview,
                isHeader = {itemPosition: Int ->
                    dataList[itemPosition] is Items.MyTitle
                }
            )
        )

    }
}