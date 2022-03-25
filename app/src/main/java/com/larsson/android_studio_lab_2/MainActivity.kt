package com.larsson.android_studio_lab_2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ID
        val btnToLogin = findViewById<Button>(R.id.btn_toLogin)
        val welcomeText = findViewById<TextView>(R.id.textView2)


        // On click - Go to LoginActivity
        btnToLogin.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        // Email-address from login (fetching data from Intent from LoginActivity)
        val emailIntentValue = intent.getStringExtra("Email")

        // Checking if user has tried to login yet
        if (emailIntentValue == null) {
            welcomeText.text = "Hi, please login"
        } else {
            welcomeText.text = "Welcome back $emailIntentValue"
        }

    }
}