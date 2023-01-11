package edu.singaporetech.travelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

/**
 * Lab 02: Travel App
 * Main Screen
 *
 * borrowed from jeannie
 */

class MainActivity : AppCompatActivity() {

    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO findviewbyid for the UI elements
        val button = findViewById<Button>(R.id.button);
        val button2 = findViewById<Button>(R.id.button2);
        val button3 = findViewById<Button>(R.id.button3);
        // TODO set onClickListeners to all the buttons here
        //  or declare the onclick method within the layout XML?
        button.setOnClickListener {
            val intent = Intent(this, TempConverterActivity::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this, CurrencyConverterActivity::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this, EmailActivity::class.java)
            startActivity(intent)
        }
    }
}