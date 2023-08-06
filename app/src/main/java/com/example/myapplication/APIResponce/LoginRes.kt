package com.example.myapplication.APIResponce

import com.example.myapplication.APIResponce.ResponceData.LoginData

data class LoginRes (
    val data: LoginData,
    val message: String,
    val status: Boolean,
    val token: String
)