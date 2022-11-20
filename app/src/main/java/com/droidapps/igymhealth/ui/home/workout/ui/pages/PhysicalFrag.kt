package com.droidapps.igymhealth.ui.home.workout.ui.pages

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.droidapps.igymhealth.R

class PhysicalFrag : Fragment() {

    companion object {
        fun newInstance() = PhysicalFrag()
    }

    private lateinit var viewModel: PhysicalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_physical, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PhysicalViewModel::class.java)
        // TODO: Use the ViewModel
    }

}