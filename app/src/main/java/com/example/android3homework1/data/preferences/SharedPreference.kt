package com.example.android3homework1.data.preferences

import android.content.Context
import android.content.SharedPreferences

object SharedPreference {

    private lateinit var sharedPreferences: SharedPreferences
    private const val USER_NAME = "user_name"
    private const val AGE_KEY = "age"
    private const val EMAIL_KEY = "email"
    private const val PASSWORD_KEY = "password"
    private const val IS_SHOW_MVVM = "isShowMVVM"
    private const val PREF_NAME = "SharedPreference"

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    var isShownOnBoard: Boolean
        get() = sharedPreferences.getBoolean(IS_SHOW_MVVM, false)
        set(value) {
            sharedPreferences.edit().putBoolean(IS_SHOW_MVVM, value).apply()
        }

    var userName: String?
        set(value) {
            sharedPreferences.edit().putString(USER_NAME, value).apply()
        }
        get() = sharedPreferences.getString(USER_NAME, "")

    var age: String?
        set(value) {
            sharedPreferences.edit().putString(AGE_KEY, value).apply()
        }
        get() = sharedPreferences.getString(AGE_KEY, "")

    var email: String?
        set(value) {
            sharedPreferences.edit().putString(EMAIL_KEY, value).apply()
        }
        get() = sharedPreferences.getString(EMAIL_KEY, "")

    var password: String?
        set(value) {
            sharedPreferences.edit().putString(PASSWORD_KEY, value).apply()
        }
        get() = sharedPreferences.getString(PASSWORD_KEY, "")
}