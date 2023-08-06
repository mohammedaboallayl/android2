package com.example.myapplication.APIResponce

import com.example.myapplication.APIResponce.ResponceData.SignUpData

data class SignUpRes(val data: SignUpData,
                     val message: String,
                     val status: Boolean,
                     val token: String)
