package com.example.taskdvm02.retrofit

import com.example.taskdvm02.model.DataModel
import com.example.taskdvm02.model.Value
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("jokes")
    fun getData(): Call<DataModel>
}