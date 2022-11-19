package com.droidapps.igymhealth.ui.home.workout.ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.droidapps.igymhealth.R

class MentalFragment : Fragment() {

    companion object {
        fun newInstance() = MentalFragment()
    }

    private lateinit var viewModel: MentalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mental, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MentalViewModel::class.java)
        // TODO: Use the ViewModel
    }

}