package edu.singaporetech.travelapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity that displays UI to convert currency
 */
class CurrencyConverterActivity : AppCompatActivity() {

    val TAG: String = "CurrencyConverterActivity"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_converter)

        // TODO findviewbyid for the UI elements
        val editTextCurrency = findViewById<EditText>(R.id.editTextCurrency)
        val editTextRate = findViewById<EditText>(R.id.editTextRate)
        val editTextSingDollar = findViewById<EditText>(R.id.editTextSingDollar)
        val convertBtn = findViewById<Button>(R.id.convert_btn)
        val displayCurrencyResult = findViewById<TextView>(R.id.display_currency_result)

        // TODO set onClickListeners to all the buttons here
        //  or declare the onClick method within the layout XML?
        convertBtn.setOnClickListener {
            if(editTextCurrency.text.isEmpty()) {

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("Please enter the currency")
                builder.setPositiveButton("OK") { _, _ ->
                    // Do nothing
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()

                return@setOnClickListener
            }
            if(editTextRate.text.isEmpty()) {

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("Please enter the rate")
                builder.setPositiveButton("OK") { _, _ ->
                    // Do nothing
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()

                return@setOnClickListener
            }
            if(editTextSingDollar.text.isEmpty()) {

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("Please enter the Singapore Dollars")
                builder.setPositiveButton("OK") { _, _ ->
                    // Do nothing
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()

                return@setOnClickListener
            }
            val rateValue = editTextRate.text.toString().toFloat()
            val sing = editTextSingDollar.text.toString().toFloat()
            displayCurrencyResult.text = editTextSingDollar.text.toString() + " SGD is " + calculateRate(sing, rateValue).toString() + " " + editTextCurrency.text
        }
    }

    /**
     * Formula to calculate the destination currency
     * @param value
     * @param exchangeRate
     * @return
     */
    private fun calculateRate(value: Float, exchangeRate: Float): Float {
        return value * exchangeRate
    }

}