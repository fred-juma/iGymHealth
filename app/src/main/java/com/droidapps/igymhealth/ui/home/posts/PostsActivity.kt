package com.droidapps.igymhealth.ui.home.posts

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.droidapps.igymhealth.R
import com.droidapps.igymhealth.databinding.ActivityPostsBinding
import com.droidapps.igymhealth.ui.home.posts.ui.main.PostPageAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PostsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostsBinding
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tabLayout = findViewById(R.id.post_tabs)
        viewPager = findViewById(R.id.post_pager)

        val viewPager: ViewPager2 = binding.postPager
        viewPager.adapter = PostPageAdapter(this)
        TabLayoutMediator(tabLayout, viewPager){tab, index ->
            tab.text = when(index){
                0 -> { "Mental" }
                1 -> { "Workout" }
                else -> { throw Resources.NotFoundException("Position Not Found")}
            }
        }.attach()

        val fab: FloatingActionButton = binding.fab

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}