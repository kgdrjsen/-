package com.android.apptest6recyclerview

sealed class Items {
    data class MyItem(val aImg:Int, val aName:String, val aAge:String) : Items()
    data class MyTitle(val age : String) : Items()
}


