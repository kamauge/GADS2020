package com.regera.gads2020.models

import com.google.gson.annotations.SerializedName

data class Details (
    val firstName: String,
    @SerializedName("Last Name")
    val lastName: String,
    @SerializedName("Email Address")
    val emailAddress: String,
    @SerializedName("Link to project")
    val github:String
)
