package com.droidapps.igymhealth.ui.home.workout.ui

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.droidapps.igymhealth.ui.home.workout.ui.pages.MentalFragment
import com.droidapps.igymhealth.ui.home.workout.ui.pages.PhysicalFrag

class WorkoutPageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> PhysicalFrag()
            1 -> MentalFragment ()
            else -> { throw Resources.NotFoundException("Position Not Found")}
        }
    }


}