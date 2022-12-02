package com.droidapps.igymhealth.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast.*
import androidx.appcompat.app.AppCompatActivity
import com.droidapps.igymhealth.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth


class SignUpActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.registerBtn.setOnClickListener {
            val email = binding.email.text.toString()
            val pass = binding.password.text.toString()
            val confirmPass = binding.confirmPassword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {


                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        } else {
                            makeText(this, it.exception.toString(), LENGTH_SHORT).show()

                        }
                    }
                } else {
                    makeText(this, "Password is not matching", LENGTH_SHORT).show()
                }
            } else {
                makeText(this, "Empty Fields Are not Allowed !!", LENGTH_SHORT).show()

            }
        }
    }

}