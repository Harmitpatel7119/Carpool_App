package com.example.carpoolapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btnLogout = findViewById<Button>(R.id.btnLogout)
        val btnSettings = findViewById<Button>(R.id.btnSettings)


        btnLogout.setOnClickListener {
            Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show()


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            finish()
        }


        btnSettings.setOnClickListener {

            Toast.makeText(this, "Settings button clicked!", Toast.LENGTH_SHORT).show()

        }
    }
}
