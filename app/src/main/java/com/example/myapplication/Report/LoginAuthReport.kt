package com.example.myapplication.Report

import com.example.myapplication.APIFormInterface.LoginForm
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginAuthReport {
    val URL="https://android-training.appssquare.com/api/login"
    val Loginform = Retrofit
            .Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(LoginForm::class.java)

    suspend fun login(email: String, password: String) = Loginform.login(email, password)
}
