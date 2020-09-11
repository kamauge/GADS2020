package com.regera.gads2020.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.regera.gads2020.R
import com.regera.gads2020.adapters.HoursAdapter
import com.regera.gads2020.models.Hours
import com.regera.gads2020.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LearningFragment : Fragment() {
    private var hourList  = ArrayList<Hours>()
    lateinit var hourRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_learning, container, false)

        hourRecyclerView = view.findViewById(R.id.learning_recycler_view);
        hourRecyclerView.adapter = HoursAdapter(context,hourList)
        hourRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        loadHoursData()

        return view
    }

    private fun loadHoursData(){
        val apiService = ApiService.create().getLeaders()
        apiService.enqueue(object : Callback<List<Hours>> {
            override fun onResponse(call: Call<List<Hours>>, response: Response<List<Hours>>) {
                if (response.body() != null)
                {
                    hourList.addAll(response.body()!!)
                    hourRecyclerView.adapter?.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<Hours>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


}
