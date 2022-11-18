package com.droidapps.igymhealth.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.droidapps.igymhealth.R
import com.droidapps.igymhealth.data.cards.*
import com.droidapps.igymhealth.databinding.FragmentHomeBinding
import com.droidapps.igymhealth.ui.dashboard.DashboardFragment

class HomeFragment : Fragment(), CardClickListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onClick(cards: Cards) {
        val intent = Intent(context, DashboardFragment::class.java)
//        intent.putExtra(ID_EXTRA, cards.id)
//        startActivity(intent)
        //TODO: direct the cards to the respective places, using the id
       findNavController().navigate(R.id.navigation_dashboard)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mainActivity = this
        val homeViewModel =

            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recyclerView.apply{
            layoutManager = GridLayoutManager(context, 2)
            adapter = CardAdapter(cardList, mainActivity)
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.setOnClickListener{
            findNavController().navigate(R.id.navigation_dashboard)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}