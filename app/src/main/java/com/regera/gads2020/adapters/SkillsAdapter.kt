package com.regera.gads2020.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.regera.gads2020.R
import com.regera.gads2020.models.Skills
import kotlinx.android.synthetic.main.skill_leader.view.*

class SkillsAdapter(private val context: Context?,  private var skillList:List<Skills>):
    RecyclerView.Adapter<SkillsAdapter.SkillViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.skill_leader,parent,false)
        return SkillViewHolder(view)
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        holder.bind(skillList[position])
    }

    override fun getItemCount() = skillList.size

    inner class SkillViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(skills: Skills) {
            itemView.learner_name.text = skills.name.toString()
            itemView.learner_country.text = skills.country.toString()
            itemView.learner_score.text = skills.score.toString() +" " +"Skill IQ Score" + ", "
            if (context != null) {
                Glide.with(context).load(skills.badgeUrl).into(itemView.skill_badge)
            }


        }


    }

}