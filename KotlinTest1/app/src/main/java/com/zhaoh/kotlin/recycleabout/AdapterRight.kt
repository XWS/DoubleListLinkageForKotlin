package com.zhaoh.kotlin.recycleabout

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhaoh.kotlin.bean.CityBean

/**
 * Created by 19208 on 2017/5/29.
 */
class AdapterRight(var LayoutRes: Int, var mData: List<CityBean>) : RecyclerView.Adapter<ViewHolderRight>() {

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): ViewHolderRight {
        return ViewHolderRight(LayoutInflater.from(p0?.context).inflate(LayoutRes, p0, false))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(p0: ViewHolderRight?, p1: Int) {
        p0?.tv?.text = mData[p1].name
    }

}