package com.android.applemarket

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.applemarket.databinding.ItemRecyclerviewBinding
import java.text.DecimalFormat

class MyAdapter (val dItems:MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder> (){

    interface ItemClick {
        fun onClick(view : View, position:Int)
    }

    interface  ItemLongClick {
        fun onLongClick(view : View, position: Int)
    }

    var itemClick : ItemClick? = null
    var itemLongClick : ItemLongClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        Log.d("MyAdatper","onCreateViewHolder()")
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Log.d("MyAdatper","onBindViewHolder() position = $position")
        holder.itemView.setOnClickListener{
            itemClick?.onClick(it,position)

        }
        holder.itemView.setOnLongClickListener {
            itemLongClick?.onLongClick(it,position)
            return@setOnLongClickListener true
        }
        holder.img.setImageResource(dItems[position].aImg)
        holder.title.text = dItems[position].aTitle
        holder.userid.text = dItems[position].aUserid
        //천단위로 콤마 + 원
        holder.price.text = DecimalFormat("#,###").format(dItems[position].aPrice) + "원"
//        holder.price.text = dItems[position].aPrice.toString()
        holder.chat.text = dItems[position].aChat.toString()
        holder.heart.text = dItems[position].aHeart.toString()

        //리사이클러뷰에 좋아요 표시 띄우기
        if (dItems[position].isLike) {
            holder.imgLike.setImageResource(R.drawable.heart2)
        } else {
            holder.imgLike.setImageResource(R.drawable.heart)
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return dItems.size
    }
    //강제로 바꾸고 싶다면
    //마이 아이템 클래스에서 val을 var로 바꾸면 됨
//    fun updateName(position: Int, newTitle :String) {
//        dItems.get(position).aTitle = newTitle
//
//        //바꾸려면 어댑터에 반드시 notifydata에 알려야한다.
//        //setchanged는 전체를 바꿈
//        notifyDataSetChanged()
//        //그 부분만 바꿈
//        notifyItemChanged(position)
//        //지운 데이터에 대해 다시 해줘야함
//        notifyItemRemoved(position)
//        //추가
//        notifyItemInserted(position)
//    }



    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val img = binding.imgItem
        val title = binding.txtTitle
        val userid = binding.txtUserId
        val price = binding.txtPrice
        val chat = binding.chatCount
        val heart = binding.heartCount
        val imgLike = binding.imgHeart

    }

}