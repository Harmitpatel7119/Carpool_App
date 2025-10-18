package com.example.carpoolapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivitySignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val etFullName = findViewById<EditText>(R.id.etFullName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        val btnLog = findViewById<Button>(R.id.btnLog) // make sure this matches your XML ID

        btnSignUp.setOnClickListener {
            val fullName = etFullName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please enter all data", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPref = getSharedPreferences("userData", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("FullName", fullName)
                editor.putString("email", email)
                editor.putString("password", password)
                editor.putString("login", "false")
                editor.apply()

                Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, FindActivity::class.java)
                startActivity(intent)
            }
        }

        btnLog.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
