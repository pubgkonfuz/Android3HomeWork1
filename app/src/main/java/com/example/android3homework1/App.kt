package com.example.android3homework1

import android.app.Application
import com.example.android3homework1.data.preferences.SharedPreference

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPreference.init(this)
    }
}