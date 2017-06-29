package com.gr.selectionrecyclerview.util

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import com.gr.selectionrecyclerview.entity.City

/**
 * Created by gr on 2017/6/17.
 */
class ProvinceDecoration(val datas: ArrayList<City>) : RecyclerView.ItemDecoration() {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val height = ViewUtil.dp2px(40f)

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val childCount = parent.childCount
        val itemCount = state.itemCount
        val left = parent.left + parent.paddingLeft + ViewUtil.dp2px(16f)
        val right = parent.right - parent.paddingRight.toFloat()

        var prevProvince: String?
        var currentProvince: String? = null
        for (i in 0..childCount - 1) {
            val child = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(child)
            prevProvince = currentProvince
            currentProvince = datas[position].province
            if (currentProvince == prevProvince) continue

            val childBottom = child.bottom.toFloat()
            var bottom = Math.max(height, child.top.toFloat())
            if (position != itemCount - 1 && currentProvince != datas[position + 1].province
                    && childBottom < bottom)
                bottom = childBottom
            paint.color = Color.GRAY
            c.drawRect(0f, bottom - height, right, bottom, paint)

            paint.textSize = ViewUtil.sp2px(16f)
            paint.color = Color.WHITE
            val metrics = paint.fontMetrics
            val baseLine = bottom - (height - (metrics.bottom - metrics.top)) / 2 - metrics.bottom
            c.drawText(currentProvince, left, baseLine, paint)
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        if (position == 0 || datas[position].province != datas[position - 1].province)
            outRect.top = height.toInt()
    }
}