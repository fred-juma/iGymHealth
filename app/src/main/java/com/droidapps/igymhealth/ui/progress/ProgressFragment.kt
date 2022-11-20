package com.droidapps.igymhealth.ui.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.droidapps.igymhealth.databinding.FragmentProgressBinding


class ProgressFragment : Fragment() {

    private var _binding: FragmentProgressBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val progressViewModel =
            ViewModelProvider(this).get(ProgressViewModel::class.java)

        _binding = FragmentProgressBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textProgress
        progressViewModel.text.observe(viewLifecycleOwner){
            textView.text = it
        }
        return root
        //return inflater.inflate(R.layout.fragment_progress, container, false)
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
}