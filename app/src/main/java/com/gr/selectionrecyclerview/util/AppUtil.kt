package com.gr.selectionrecyclerview.util

import android.app.Application

/**
 * Created by gr on 2017/6/17.
 */
class AppUtil:Application() {

    override fun onCreate() {
        super.onCreate()
        application=this
    }

    companion object{
        lateinit var application:AppUtil
    }
}