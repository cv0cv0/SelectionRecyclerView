package com.gr.selectionrecyclerview.util

import android.util.TypedValue

/**
 * Created by gr on 2017/6/17.
 */
object ViewUtil {
    private val context = AppUtil.application

    fun dp2px(dp: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics)
    }

    fun sp2px(sp: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.resources.displayMetrics)
    }
}