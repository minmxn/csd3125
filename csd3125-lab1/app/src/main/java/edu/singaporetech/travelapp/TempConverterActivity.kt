package edu.singaporetech.travelapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


/**
 * Activity that displays UI to convert temperature
 */
class TempConverterActivity : AppCompatActivity() {

    val TAG: String = "TempConverter"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp_converter)

        // TODO findviewbyid for the UI elements
        val editTextTemp = findViewById<EditText>(R.id.editTextTemp)
        val convertTempBtn = findViewById<Button>(R.id.convert_temp_btn)
        val clearBtn = findViewById<Button>(R.id.clear_btn)
        val displayTempResult = findViewById<TextView>(R.id.display_temp_result)
        val toFahrenheitRb = findViewById<RadioButton>(R.id.to_fahrenheit_rb)
        val toCelsiusRb = findViewById<RadioButton>(R.id.to_celsius_rb)
        val radioGroup = findViewById<RadioGroup>(R.id.radiogroup)

        // TODO set onClickListeners to all the buttons here
        //  or declare the onclick method within the layout XML?

        convertTempBtn.setOnClickListener {
            if(editTextTemp.text.isEmpty()) {

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("Please enter the temperature")
                builder.setPositiveButton("OK") { _, _ ->
                    // Do nothing
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()

                return@setOnClickListener
            }
            if (toFahrenheitRb.isChecked)
            {
                val tempValue = editTextTemp.text.toString().toFloat()
                displayTempResult.text = editTextTemp.text.toString() + " Celsius is " + convertCelsiusToFahrenheit(tempValue).toString() + " Fahrenheit"
            }
            else if (toCelsiusRb.isChecked)
            {
                val tempValue = editTextTemp.text.toString().toFloat()
                displayTempResult.text = editTextTemp.text.toString() + " Fahrenheit is " + convertFahrenheitToCelsius(tempValue).toString() + " Celsius"
            }
        }

        clearBtn.setOnClickListener {
            displayTempResult.text = ""
        }
    }

    // TODO - Implement the temperature conversion logic and other behavior here
    //  What methods do you need?

    /**
     * Converts fahrenheit to celsius
     * @param fahrenheit temperature in f
     * @return
     */
    private fun convertFahrenheitToCelsius(fahrenheit: Float): Float {
        return (fahrenheit - 32) * (5.0F/9)
    }

    /**
     * Converts celsius to fahrenheit
     * @param celsius temperature in c
     * @return
     */
    fun convertCelsiusToFahrenheit(celsius: Float): Float {
        return celsius * (9/5.0F) + 32
    }

}