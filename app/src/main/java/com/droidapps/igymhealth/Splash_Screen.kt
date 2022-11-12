package com.droidapps.igymhealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import android.os.Handler
import android.view.animation.AnimationUtils
import java.util.jar.Manifest

@Suppress("DEPRECATION")
class Splash_Screen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val bgImage:ImageView = findViewById(R.id.SplashScreenImage)
        val sideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
        bgImage.startAnimation(sideAnimation)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000) //Delay for 4secs
    }

}