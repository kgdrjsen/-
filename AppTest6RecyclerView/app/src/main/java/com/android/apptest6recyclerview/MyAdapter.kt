package com.android.apptest6recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.apptest6recyclerview.databinding.ItemRecyclerviewBinding

class MyAdapter (val dItems:MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder> () {

    interface ItemClick {
        fun onClick(view : View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener{
            itemClick?.onClick(it,position)
        }
        holder.ivImageView.setImageResource(dItems[position].aImg)
        holder.name.text = dItems[position].aName
        holder.age.text = dItems[position].aAge
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return dItems.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val ivImageView = binding.imgItem
        val name = binding.txtItem1
        val age = binding.txtItem2
    }



}