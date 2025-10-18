package com.example.carpoolapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FindActivity : AppCompatActivity() {

    private lateinit var etPickup: EditText
    private lateinit var etDropoff: EditText
    private lateinit var etDateTime: EditText
    private lateinit var btnFindRide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find)

        etPickup = findViewById(R.id.etPickup)
        etDropoff = findViewById(R.id.etDropoff)
        etDateTime = findViewById(R.id.etDateTime)
        btnFindRide = findViewById(R.id.btnFindRide)


        btnFindRide.setOnClickListener {
            val pickup = etPickup.text.toString().trim()
            val dropoff = etDropoff.text.toString().trim()
            val dateTime = etDateTime.text.toString().trim()


            if (pickup.isEmpty() || dropoff.isEmpty() || dateTime.isEmpty()) {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
            } else {

                val intent = Intent(this, AvailableRidesActivity::class.java)


                intent.putExtra("pickup_location", pickup)
                intent.putExtra("dropoff_location", dropoff)
                intent.putExtra("ride_datetime", dateTime)


                startActivity(intent)
            }
        }
    }
}
