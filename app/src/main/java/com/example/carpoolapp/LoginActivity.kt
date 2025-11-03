package com.example.carpoolapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.Email)
        val password = findViewById<EditText>(R.id.Password)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnSignup = findViewById<Button>(R.id.btnSignup)

        btnLogin.setOnClickListener {
            val email = email.text.toString().trim()
            val password = password.text.toString().trim()

            val sharedPref = getSharedPreferences("userData", MODE_PRIVATE)
            val orgEmail = sharedPref.getString("email", "") ?: ""
            val orgPassword = sharedPref.getString("password", "") ?: ""

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter all data", Toast.LENGTH_SHORT).show()
            } else if (email != orgEmail || password != orgPassword) {
                Toast.makeText(this, "User not available", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, FindActivity::class.java)
                startActivity(intent)
            }
        }

        btnSignup.setOnClickListener {
            val intent = Intent(this, ActivitySignUp::class.java)
            startActivity(intent)
            finish()
        }
    }
}
