package com.regera.gads2020.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.regera.gads2020.R
import com.regera.gads2020.models.Skills
import com.regera.gads2020.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.regera.gads2020.adapters.SkillsAdapter as SkillsAdapter

class SkillFragment : Fragment(R.layout.fragment_skill) {
    private var skillList  = ArrayList<Skills>()
    lateinit var skillRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_skill, container, false)

        skillRecyclerView = view.findViewById(R.id.skill_recycler_view);
        skillRecyclerView.adapter = SkillsAdapter(context,skillList)
        skillRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        loadSkillsData()

        return view
    }

    private fun loadSkillsData(){
        val apiService = ApiService.create().getSkillIQ()
        apiService.enqueue(object : Callback<List<Skills>> {
            override fun onResponse(
                call: Call<List<Skills>>,
                response: Response<List<Skills>>) {
                if (response.body() != null)
                {
                 skillList.addAll(response.body()!!)
                    skillRecyclerView.adapter?.notifyDataSetChanged()
                }

            }

            override fun onFailure(call: Call<List<Skills>>, t: Throwable) {

            }

        })
    }


}