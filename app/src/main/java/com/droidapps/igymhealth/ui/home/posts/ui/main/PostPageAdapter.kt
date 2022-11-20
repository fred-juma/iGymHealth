package com.droidapps.igymhealth.ui.home.posts.ui.main

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PostPageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> MentalFrag()
            1 -> WorkoutFrag()
            else -> { throw Resources.NotFoundException("Position Not Found")}
        }
    }
}