package com.zhaoh.kotlin.recycleabout

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.zhaoh.kotlin.R

/**
 * Created by 19208 on 2017/5/28.
 */
class ViewHolderLeft(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var left_layout: LinearLayout = itemView?.findViewById(R.id.leftLayout) as LinearLayout
    var tv_tag: TextView = itemView?.findViewById(R.id.cityTag) as TextView
    var tv_line: View = itemView?.findViewById(R.id.line) as View
}