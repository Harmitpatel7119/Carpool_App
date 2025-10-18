package com.example.carpoolapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AvailableRidesActivity : AppCompatActivity() {

    // Declare all the buttons
    private lateinit var price1: Button
    private lateinit var price2: Button
    private lateinit var price3: Button
    private lateinit var price4: Button
    private lateinit var price5: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_available_rides)

        // Initialize buttons by their IDs from the XML
        price1 = findViewById(R.id.price1)
        price2 = findViewById(R.id.price2)
        price3 = findViewById(R.id.price3)
        price4 = findViewById(R.id.price4)
        price5 = findViewById(R.id.price5)

        // Set up click listeners for each button
        setButtonClickListener(price1)
        setButtonClickListener(price2)
        setButtonClickListener(price3)
        setButtonClickListener(price4)
        setButtonClickListener(price5)
    }

    private fun setButtonClickListener(button: Button) {
        button.setOnClickListener {

            resetButtonColors()


            button.setBackgroundColor(Color.parseColor("#00796B"))
            button.setTextColor(Color.WHITE)

            val selectedPrice = button.text.toString()


            val intent = Intent(this, ConfirmActivity::class.java)
            intent.putExtra("SELECTED_PRICE", selectedPrice) // send the selected price
            startActivity(intent)
        }
    }

    private fun resetButtonColors() {
        val allButtons = listOf(price1, price2, price3, price4, price5)

        for (btn in allButtons) {
            btn.setBackgroundColor(Color.TRANSPARENT)
            btn.setTextColor(Color.parseColor("#00796B"))
        }
    }
}
