package com.example.android3homework1.ui.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3homework1.data.preferences.SharedPreference
import com.example.android3homework1.utils.UiState

class UserViewModel : ViewModel() {

    private var _userData = MutableLiveData<UiState<UserModel>>()
    val userData: LiveData<UiState<UserModel>> = _userData

    fun updateUserModel(userModel: UserModel) {
        val uiState = UiState(false, "", userModel)
        _userData.value = uiState
    }

    fun saveUser(userModel: UserModel) = with(userModel) {
        SharedPreference.userName = userName
        SharedPreference.age = age
        SharedPreference.email = email
        SharedPreference.password = password
    }

    fun getUser() = with(SharedPreference) {
        val user = UserModel(
            userName = userName ?: "",
            age = age ?: "",
            email = email ?: "",
            password = password ?: ""
        )
        Log.e("success", "getUser: $user", )
        _userData.value = UiState(isLoading = false, success = user)
    }
}