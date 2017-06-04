package com.zhaoh.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.zhaoh.kotlin.recycleabout.AdapterRight
import com.zhaoh.kotlin.bean.CityBean
import com.zhaoh.kotlin.bean.TagBean
import com.zhaoh.kotlin.dao.onClick
import com.zhaoh.kotlin.recycleabout.AdapterLeft
import zhaoh.com.kotlin.mykotlinproject.recycleabout.TitleItemDecoration

class MainActivity : AppCompatActivity() {

    private var lastCheck: Int = 0
    private var layoutMangerLeft: LinearLayoutManager? = null
    private var layoutMangerRight: LinearLayoutManager? = null
    private var adapterLeft: AdapterLeft? = null

    val mDataRight = listOf(
            CityBean("A", "安徽")
            , CityBean("B", "北京")
            , CityBean("F", "福建")
            , CityBean("G", "广东")
            , CityBean("G", "甘肃")
            , CityBean("G", "贵州")
            , CityBean("G", "广西")
            , CityBean("H", "河南")
            , CityBean("H", "湖北")
            , CityBean("H", "湖南")
            , CityBean("H", "河北")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("R", "日本")
            , CityBean("R", "日本")
            , CityBean("R", "日本")
            , CityBean("R", "日本")

            , CityBean("C", "北京")
            , CityBean("C", "福建")
            , CityBean("C", "广东")
            , CityBean("C", "甘肃")
            , CityBean("C", "贵州")

            , CityBean("D", "广西")
            , CityBean("D", "河南")
            , CityBean("D", "广东")
            , CityBean("D", "甘肃")
            , CityBean("D", "贵州")

            , CityBean("E", "北京")
            , CityBean("E", "福建")
            , CityBean("E", "广东")
            , CityBean("E", "甘肃")
            , CityBean("E", "贵州")

            , CityBean("I", "北京")
            , CityBean("I", "福建")
            , CityBean("I", "广东")
            , CityBean("I", "甘肃")
            , CityBean("I", "贵州")

            , CityBean("K", "北京")
            , CityBean("K", "福建")
            , CityBean("K", "广东")
            , CityBean("K", "甘肃")
            , CityBean("K", "贵州")

            , CityBean("L", "北京")
            , CityBean("L", "福建")
            , CityBean("L", "广东")
            , CityBean("L", "甘肃")
            , CityBean("L", "贵州")

            , CityBean("M", "北京")
            , CityBean("M", "福建")
            , CityBean("M", "广东")
            , CityBean("M", "甘肃")
            , CityBean("M", "贵州")

            , CityBean("N", "北京")
            , CityBean("N", "福建")
            , CityBean("N", "广东")
            , CityBean("N", "甘肃")
            , CityBean("N", "贵州")

            , CityBean("O", "北京")
            , CityBean("O", "福建")
            , CityBean("O", "广东")
            , CityBean("O", "甘肃")
            , CityBean("O", "贵州")

            , CityBean("P", "北京")
            , CityBean("P", "福建")
            , CityBean("P", "广东")
            , CityBean("P", "甘肃")
            , CityBean("P", "贵州")

            , CityBean("Q", "北京")
            , CityBean("Q", "福建")
            , CityBean("Q", "广东")
            , CityBean("Q", "甘肃")
            , CityBean("Q", "贵州")

            , CityBean("S", "北京")
            , CityBean("S", "福建")
            , CityBean("S", "广东")
            , CityBean("S", "甘肃")
            , CityBean("S", "贵州")

            , CityBean("T", "北京")
            , CityBean("T", "福建")
            , CityBean("T", "广东")
            , CityBean("T", "甘肃")
            , CityBean("T", "贵州")

            , CityBean("U", "北京")
            , CityBean("U", "福建")
            , CityBean("U", "广东")
            , CityBean("U", "甘肃")
            , CityBean("U", "贵州"))

    val mDataLeft = listOf(
            TagBean("A", true)
            , TagBean("B", false)
            , TagBean("F", false)
            , TagBean("G", false)
            , TagBean("H", false)
            , TagBean("J", false)
            , TagBean("R", false)
            , TagBean("C", false)
            , TagBean("D", false)
            , TagBean("E", false)
            , TagBean("I", false)
            , TagBean("K", false)
            , TagBean("L", false)
            , TagBean("M", false)
            , TagBean("N", false)
            , TagBean("O", false)
            , TagBean("P", false)
            , TagBean("Q", false)
            , TagBean("S", false)
            , TagBean("T", false)
            , TagBean("U", false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {
        val recycleViewRight = findViewById(R.id.recyclerViewRight) as RecyclerView
        recycleViewRight.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        layoutMangerRight = recycleViewRight.layoutManager as LinearLayoutManager
        recycleViewRight.addItemDecoration(TitleItemDecoration(this, mDataRight))
        recycleViewRight.adapter = AdapterRight(R.layout.item_right, mDataRight)
        recycleViewRight.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val firstVisibleItem = layoutMangerRight?.findFirstVisibleItemPosition()
                val lastVisibleItem = layoutMangerRight?.findLastVisibleItemPosition()
                if (firstVisibleItem!! > 0) {
                    if (lastVisibleItem == mDataRight.size - 1) {
                        mDataLeft[lastCheck].isChecked = false
                        mDataLeft[mDataLeft.size - 1].isChecked = true
                        lastCheck = mDataLeft.size - 1
                        adapterLeft?.notifyDataSetChanged()
                        layoutMangerLeft?.scrollToPosition(mDataLeft.size - 1)
                    } else if (mDataRight[firstVisibleItem - 1].tag != mDataRight[firstVisibleItem].tag) {
                        var index = 0
                        while (index < mDataLeft.size) {
                            if (mDataRight[firstVisibleItem].tag == mDataLeft[index].tag) {
                                mDataLeft[lastCheck].isChecked = false
                                mDataLeft[index].isChecked = true
                                lastCheck = index
                                adapterLeft?.notifyDataSetChanged()
                                if (index !in layoutMangerLeft!!.findFirstVisibleItemPosition()..layoutMangerLeft!!.findLastVisibleItemPosition()) {
                                    layoutMangerLeft?.scrollToPosition(index)
                                }
                                break
                            }
                            index++
                        }
                    }
                } else if (firstVisibleItem == 0) {
                    mDataLeft[lastCheck].isChecked = false
                    mDataLeft[0].isChecked = true
                    lastCheck = 0
                    adapterLeft?.notifyDataSetChanged()
                    layoutMangerLeft?.scrollToPositionWithOffset(0, 0)
                }
            }
        })

        val recyclerViewLeft = findViewById(R.id.recyclerViewLeft) as RecyclerView
        recyclerViewLeft.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        layoutMangerLeft = recyclerViewLeft.layoutManager as LinearLayoutManager
        recyclerViewLeft.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapterLeft = AdapterLeft(R.layout.item_left, mDataLeft)
        adapterLeft?.setOnItemClickListenerLeft(object : onClick<Int> {
            override fun call(postion: Int?) {
                if (lastCheck == postion) {
                    return
                } else {
                    mDataLeft[lastCheck].isChecked = false
                    mDataLeft[postion!!].isChecked = true
                    lastCheck = postion

                    var index: Int = 0
                    while (index < mDataRight.size) {
                        if (mDataLeft[postion].tag == mDataRight[index].tag) {
                            layoutMangerRight?.scrollToPositionWithOffset(index, 0)
                            break
                        }
                        index++
                    }
                    adapterLeft?.notifyDataSetChanged()
                }
            }
        })
        recyclerViewLeft.adapter = adapterLeft
    }
}
