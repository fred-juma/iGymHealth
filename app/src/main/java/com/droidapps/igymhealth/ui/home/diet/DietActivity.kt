package com.droidapps.igymhealth.ui.home.diet

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.droidapps.igymhealth.R
import com.droidapps.igymhealth.databinding.ActivityDietBinding
import com.droidapps.igymhealth.ui.home.diet.ui.main.DietPageAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DietActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDietBinding
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDietBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tabLayout = findViewById(R.id.diet_tabs)
        viewPager = findViewById(R.id.diet_pager)

        val viewPager: ViewPager2 = binding.dietPager
        viewPager.adapter = DietPageAdapter(this)
        TabLayoutMediator(tabLayout, viewPager){tab, index ->
            tab.text = when(index){
                0 -> { "Feed" }
                1 -> { "Favorites" }
                else -> { throw Resources.NotFoundException("Position Not Found")}
            }
        }


        val fab: FloatingActionButton = binding.fab

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}