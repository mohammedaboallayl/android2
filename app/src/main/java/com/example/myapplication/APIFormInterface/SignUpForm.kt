package com.example.myapplication.APIFormInterface

import com.example.myapplication.APIResponce.SignUpRes
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SignUpForm {
    @POST("signup")
    @FormUrlEncoded
    suspend fun signup(
        @Field("email") email: String?,
        @Field("password") password: String?,
        @Field("name") name: String?,
    ): Response<SignUpRes>
}