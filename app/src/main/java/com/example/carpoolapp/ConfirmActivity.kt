package com.example.carpoolapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ConfirmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val tvDriverName = findViewById<TextView>(R.id.tvDriverName)
        val tvCarModel = findViewById<TextView>(R.id.tvCarModel)
        val tvPickup = findViewById<TextView>(R.id.tvPickup)
        val tvDropoff = findViewById<TextView>(R.id.tvDropoff)
        val tvPrice = findViewById<TextView>(R.id.tvPrice)
        val btnConfirm = findViewById<Button>(R.id.btnConfirm)

        val driverName = intent.getStringExtra("driverName") ?: "Jane Smith"
        val carModel = intent.getStringExtra("carModel") ?: "Honda Civic"
        val pickup = intent.getStringExtra("pickup") ?: "123 Main St"
        val dropoff = intent.getStringExtra("dropoff") ?: "456 Oak Ave."
        val price = intent.getStringExtra("price") ?: "$12.50"


        tvDriverName.text = driverName
        tvCarModel.text = carModel
        tvPickup.text = "Pickup Location: $pickup"
        tvDropoff.text = "Drop-off Location: $dropoff"
        tvPrice.text = price


        btnConfirm.setOnClickListener {
            Toast.makeText(this, "Booking Confirmed Successfully!", Toast.LENGTH_SHORT).show()


            val intent = Intent(this, ProfileActivity::class.java)


            intent.putExtra("driverName", driverName)
            intent.putExtra("price", price)

            startActivity(intent)
            finish()
        }
    }
}
