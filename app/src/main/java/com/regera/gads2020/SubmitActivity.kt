package com.regera.gads2020

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.regera.gads2020.models.Details
import com.regera.gads2020.services.ApiService
import kotlinx.android.synthetic.main.activity_submit.*
import kotlinx.android.synthetic.main.dialog_confirm.view.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SubmitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        btnSubmit.setOnClickListener {

            validateDetails()

        }

    }

    private fun validateDetails() {

        val firstName = first_name.text.toString()
        val lastName = last_name.text.toString()
        val myEmail = email.text.toString()
        val myLink = github_link.text.toString()

        if (firstName.isEmpty()) {
            first_name.error = "First Name required"
            first_name.requestFocus()
        }

        Toast.makeText(this@SubmitActivity, firstName, Toast.LENGTH_SHORT).show()


        if (lastName.isEmpty()) {
            last_name.error = "Last Name required"
            last_name.requestFocus()
        }

        if (myEmail.isEmpty()) {
            email.error = "Email required"
            email.requestFocus()

        }

        if (myLink.isEmpty()) {
            github_link.error = "Github required"
            github_link.requestFocus()
        }

        val alertDialog = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.dialog_confirm, null)
        alertDialog.setView(dialogView)
        alertDialog.setCancelable(false)
        val customDialog = alertDialog.create()
        customDialog.show()
        dialogView.yes_button.setOnClickListener {
            saveDetails()
            customDialog.dismiss()

        }
        dialogView.close_button.setOnClickListener {
            customDialog.dismiss()
        }

    }

    private fun saveDetails(){

        val firstName = first_name.text.toString()
        val lastName = last_name.text.toString()
        val myEmail = email.text.toString()
        val myLink = github_link.text.toString()



        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
            .build()
        val jsonApiService = retrofitBuilder.create(ApiService::class.java)
            .sendProject(firstName,lastName,myEmail,myLink)
        jsonApiService.enqueue(object : Callback<Details>{
            override fun onResponse(call: Call<Details>, response: Response<Details>) {
                val alertDialog = AlertDialog.Builder(this@SubmitActivity)
                val dialogView = layoutInflater.inflate(R.layout.success, null)
                alertDialog.setView(dialogView)
                alertDialog.setCancelable(true)
                val customDialog = alertDialog.create()
                customDialog.show()

            }

            override fun onFailure(call: Call<Details>, t: Throwable) {
                val alertDialog = AlertDialog.Builder(this@SubmitActivity)
                val dialogView = layoutInflater.inflate(R.layout.failure, null)
                alertDialog.setView(dialogView)
                alertDialog.setCancelable(true)
                val customDialog = alertDialog.create()
                customDialog.show()

            }
        })


    }
}