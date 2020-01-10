package com.example.taskdvm02.model

import com.google.gson.annotations.Expose

data class Value(

    @Expose
    val id:String,
    @Expose
    val joke:String


)

data class DataModel (

    @Expose
    val type:String,
    @Expose
    val value: List<Value>
)

