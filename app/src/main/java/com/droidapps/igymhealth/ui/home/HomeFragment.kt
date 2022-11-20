package com.droidapps.igymhealth.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.droidapps.igymhealth.R
import com.droidapps.igymhealth.data.cards.*
import com.droidapps.igymhealth.databinding.FragmentHomeBinding
import com.droidapps.igymhealth.ui.home.diet.DietActivity
import com.droidapps.igymhealth.ui.home.posts.PostsActivity
import com.droidapps.igymhealth.ui.home.workout.WorkoutActivity

class HomeFragment : Fragment(), CardClickListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onClick(cards: Cards) {
        //HACK: Temporary fix for navigation and intents
        if(cards.workout == "Yoga" || cards.workout == "Weights" || cards.workout == "Meditation"){
            val intent = Intent(context, WorkoutActivity::class.java)
            intent.putExtra(ROUTE_ID, cards.id)
            startActivity(intent)
        }
        if(cards.workout == "Diet"){
            val intent = Intent(context, DietActivity::class.java)
            intent.putExtra(ROUTE_ID, cards.id)
            startActivity(intent)
        }
        if(cards.workout == "Physical Health Tips" || cards.workout == "Mental Health Tips"){
            val intent = Intent(context, PostsActivity::class.java)
            intent.putExtra(ROUTE_ID, cards.id)
            startActivity(intent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mainActivity = this

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