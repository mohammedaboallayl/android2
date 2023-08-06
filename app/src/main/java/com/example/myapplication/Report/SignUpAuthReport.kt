package com.example.myapplication.Report


import com.example.myapplication.APIFormInterface.LoginForm
import com.example.myapplication.APIFormInterface.SignUpForm
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SignUpAuthReport {

    val URL="https://android-training.appssquare.com/api/sign_up"
    private val Signform = Retrofit
            .Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(SignUpForm::class.java)

    suspend fun signup(email: String, password: String,name:String) = Signform.signup(email,password,name)
}
