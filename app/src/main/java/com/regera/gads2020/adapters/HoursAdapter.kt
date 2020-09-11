package com.regera.gads2020.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.regera.gads2020.R
import com.regera.gads2020.models.Hours
import kotlinx.android.synthetic.main.hour_leader.view.learner_country
import kotlinx.android.synthetic.main.hour_leader.view.learner_name
import kotlinx.android.synthetic.main.skill_leader.view.*

class HoursAdapter(private val context: Context?, private var hourList:List<Hours>):
    RecyclerView.Adapter<HoursAdapter.HoursViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoursViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.skill_leader,parent,false)
        return HoursViewHolder(view)
    }

    override fun onBindViewHolder(holder: HoursViewHolder, position: Int) {
        holder.bind(hourList[position])
    }

    override fun getItemCount() = hourList.size

    inner class HoursViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(skills: Hours) {
            itemView.learner_name.text = skills.name.toString()
            itemView.learner_country.text = skills.country.toString()
            itemView.learner_score.text = skills.hours.toString()+" " +"learning hours" + ", "
            if (context != null) {
                Glide.with(context).load(skills.badgeUrl).into(itemView.skill_badge)
            }


        }


    }

}