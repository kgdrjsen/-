package com.android.apptest6recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.apptest6recyclerview.databinding.ItemRecyclerviewBinding
import com.android.apptest6recyclerview.databinding.ItemTitleviewBinding

//class MyAdapter (val dItems:MutableList<Items>) : RecyclerView.Adapter<MyAdapter.Holder> () {
//
//    interface ItemClick {
//        fun onClick(view : View, position: Int)
//    }
//
//    var itemClick : ItemClick? = null
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return Holder(binding)
//    }
//
//    override fun onBindViewHolder(holder: Holder, position: Int) {
//        holder.itemView.setOnClickListener{
//            itemClick?.onClick(it,position)
//        }
////        holder.ivImageView.setImageResource(dItems[position].aImg)
////        holder.name.text = dItems[position].aName
////        holder.age.text = dItems[position].aAge
//
//    }
//
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getItemCount(): Int {
//        return dItems.size
//    }
//
//    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
//        val ivImageView = binding.imgItem
//        val name = binding.txtItem1
//        val age = binding.txtItem2
//    }
//
//
//
//}
//
class MyAdapter (val dItems:MutableList<Items>) : RecyclerView.Adapter<ViewHolder> () {

    val itemList = mutableListOf<Items>()
    companion object {
        private const val VIEW_TYPE_TITLE = 1
        private const val VIEW_TYPE_ITEM = 2
    }

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return when(viewType) {
            1 -> {
                val binding = ItemTitleviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                TitleViewHolder(binding)
            }
            2 -> {
                val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                ItemViewHolder(binding)
            }
            else-> {
                val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                ItemViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            itemClick?.onClick(it,position)
        }

        when (val item = dItems[position]) {
            is Items.MyTitle -> {
                (holder as TitleViewHolder).title.text = "${item.age} 살"
            }
            is Items.MyItem -> {
                (holder as ItemViewHolder).name.text = item.aName
                holder.age.text = item.aAge
                holder.ivImageView.setImageResource(item.aImg)
            }

        }
    }

    override fun getItemCount(): Int {
        return dItems.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return when (dItems[position]) {
            is Items.MyTitle -> VIEW_TYPE_TITLE
            is Items.MyItem -> VIEW_TYPE_ITEM
        }
    }


    inner class TitleViewHolder(binding: ItemTitleviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.txtTitle
    }
    inner class ItemViewHolder(binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val ivImageView = binding.imgItem
        val name = binding.txtItem1
        val age = binding.txtItem2
    }


}