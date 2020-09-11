package com.regera.gads2020

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.regera.gads2020.ui.LearningFragment
import com.regera.gads2020.ui.SkillFragment


class PageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                LearningFragment()
            }
            1 -> {
                SkillFragment()
            }
            else -> {
                LearningFragment()
            }
        }
    }
}
