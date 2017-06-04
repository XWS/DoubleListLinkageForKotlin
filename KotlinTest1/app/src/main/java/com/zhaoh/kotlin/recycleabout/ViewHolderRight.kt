package com.zhaoh.kotlin.recycleabout

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.zhaoh.kotlin.R

/**
 * Created by 19208 on 2017/5/28.
 */
class ViewHolderRight(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var tv: TextView = itemView?.findViewById(R.id.cityName) as TextView
}