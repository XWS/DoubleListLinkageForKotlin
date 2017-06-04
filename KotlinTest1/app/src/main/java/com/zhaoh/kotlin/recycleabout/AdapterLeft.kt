package com.zhaoh.kotlin.recycleabout

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhaoh.kotlin.bean.TagBean
import com.zhaoh.kotlin.dao.onClick

/**
 * Created by 19208 on 2017/5/29.
 */
class AdapterLeft(var LayoutRes: Int, var mData: List<TagBean>) : RecyclerView.Adapter<ViewHolderLeft>() {

    var onItemClickListener: onClick<Int>? = null

    override fun onBindViewHolder(p0: ViewHolderLeft?, p1: Int) {
        p0?.tv_tag?.text = mData[p1].tag
        if (mData[p1].isChecked) {
            p0?.tv_line?.setBackgroundColor(Color.parseColor("#FF4081"))
        } else {
            p0?.tv_line?.setBackgroundColor(Color.parseColor("#3F51B5"))
        }
        if (onItemClickListener != null) {
            p0?.left_layout?.setOnClickListener {
                onItemClickListener?.call(p1)
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): ViewHolderLeft {
        return ViewHolderLeft(LayoutInflater.from(p0?.context).inflate(LayoutRes, p0, false))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    open fun setOnItemClickListenerLeft(onItemClickAction: onClick<Int>?): Unit {
        this.onItemClickListener = onItemClickAction
    }
}