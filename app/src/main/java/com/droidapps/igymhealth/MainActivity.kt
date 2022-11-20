package com.droidapps.igymhealth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.droidapps.igymhealth.data.cards.Cards
import com.droidapps.igymhealth.data.cards.cardList
import com.droidapps.igymhealth.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        populateCards()

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_notifications, R.id.navigation_progress, R.id.navigation_dashboard
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    private fun populateCards()
    {

        val card1 = Cards(
            R.drawable.lift_weights,
            "Weights",
            "Physical",
        )
        cardList.add(card1)

        val card2 = Cards(
            R.drawable.meditation,
            "Meditation",
            "Mental",
        )
        cardList.add(card2)

        val card3 = Cards(
            R.drawable.breakfast,
            "Diet",
            "Physical",
        )
        cardList.add(card3)

        val card4 = Cards(
            R.drawable.meditation,
            "Mental Health Tips",
            "Mental",
        )
        cardList.add(card4)

        val card5 = Cards(
            R.drawable.lift_weights,
            "Physical Health Tips",
            "Physical",
        )
        cardList.add(card5)

    }
}