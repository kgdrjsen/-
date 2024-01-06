package com.android.apptest6

import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView

class ImageAdapter : BaseAdapter() {
    override fun getCount(): Int {
        return mThumbIds.size
    }

    override fun getItem(position: Int): Any {
        return mThumbIds[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView : ImageView
        if (convertView == null) {
            imageView = ImageView(parent!!.context)
            imageView.layoutParams = AbsListView.LayoutParams(200,200)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8,8,8,8)
        }else {
            imageView = convertView as ImageView
        }
        imageView.setImageResource(mThumbIds.get(position))
        return imageView
    }


    private val mThumbIds = arrayOf<Int>(
        R.drawable.sample_1, R.drawable.sample_5,
        R.drawable.sample_2, R.drawable.sample_3,
        R.drawable.sample_8, R.drawable.sample_6,
        R.drawable.sample_4, R.drawable.sample_7,
        R.drawable.sample_8, R.drawable.sample_7,
        R.drawable.sample_6, R.drawable.sample_5,
        R.drawable.sample_4, R.drawable.sample_3,
        R.drawable.sample_2, R.drawable.sample_1
    )
}