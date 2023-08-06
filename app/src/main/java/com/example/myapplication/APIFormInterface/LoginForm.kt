package com.example.myapplication.APIFormInterface

import com.example.myapplication.APIResponce.LoginRes

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginForm {
    @POST("login")
    @FormUrlEncoded
    suspend fun login(
        @Field("email") email: String?,
        @Field("password") password: String?,
    ): Response<LoginRes>
}