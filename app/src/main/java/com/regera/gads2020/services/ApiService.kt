package com.regera.gads2020.services

import com.regera.gads2020.models.Details
import com.regera.gads2020.models.Hours
import com.regera.gads2020.models.Skills
import okhttp3.Address
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiService {

    @GET("api/hours")
    fun getLeaders():Call<List<Hours>>


    @GET("api/skilliq")
    fun getSkillIQ():Call<List<Skills>>


    @POST("https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun sendProject(
        @Field("entry.1824927963") emailAddress: String,
        @Field("entry.1877115667") firstName :String,
        @Field("entry.2006916086") lastName:String,
        @Field("entry.284483984") github:String

    ):Call<Details>


    companion object {

        var BASE_URL = "https://gadsapi.herokuapp.com/"

        fun create() : ApiService {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)

        }
    }


}