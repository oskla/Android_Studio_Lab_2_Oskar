package com.larsson.android_studio_lab_2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class LoginActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        /** Giving ID's */
        val email = findViewById<EditText>(R.id.editTextTextEmail)
        val password = findViewById<EditText>(R.id.editTextTextPassword)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val loginText = findViewById<TextView>(R.id.loginText)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        val user1Email = userViewModel.user1.email
        val user1Password = userViewModel.user1.password

        // On Click to login
        btnLogin.setOnClickListener {

            // Email and password - fields
            val emailText = email.text.toString()
            val passwordText = password.text.toString()

            // Send email to MainActivity to display on textView
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("Email", emailText)
            }

            // Check if email & password is correct
            if (user1Email == emailText && user1Password == passwordText) {
                startActivity(intent)
            } else {
                loginText.text = "Incorrect email or password"
            }
        }
    }}
