package edu.singaporetech.travelapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity that emails your friend with a message
 */
class EmailActivity : AppCompatActivity() {

    private val TAG: String = "EmailActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        // TODO findviewbyid for the UI elements
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextCity = findViewById<EditText>(R.id.editTextCity)
        val displayPreviewMessage = findViewById<TextView>(R.id.display_previewmessage)
        val previewBtn = findViewById<Button>(R.id.preview_btn)
        val sendmailBtn = findViewById<Button>(R.id.sendmail_btn)

        // TODO set onClickListeners to all the buttons here
        //  or declare the onclick method within the layout XML?
        previewBtn.setOnClickListener {
            if(editTextName.text.isEmpty()) {

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("Please enter the recipient's name")
                builder.setPositiveButton("OK") { _, _ ->
                    // Do nothing
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()

                return@setOnClickListener
            }
            if(editTextCity.text.isEmpty()) {

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("Please enter the city you are flying to")
                builder.setPositiveButton("OK") { _, _ ->
                    // Do nothing
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()

                return@setOnClickListener
            }
            displayPreviewMessage.text = createEmailMessage(editTextName.text.toString() , editTextCity.text.toString())
        }

        sendmailBtn.setOnClickListener {
            if(editTextEmail.text.isEmpty()) {

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("Please the recipient's email")
                builder.setPositiveButton("OK") { _, _ ->
                    // Do nothing
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()

                return@setOnClickListener
            }
            if (isValidEmail(editTextEmail.text)) {
                sendEmail(editTextEmail.text.toString(), createEmailMessage(editTextName.text.toString() , editTextCity.text.toString()))
            }
            else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("Please enter a valid email")
                builder.setPositiveButton("OK") { _, _ ->
                    // Do nothing
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()

                return@setOnClickListener
            }
        }

        Log.d(TAG, "onCreate")
        Log.d(TAG, createEmailMessage("Jeannie", "Los Angeles"))
    }

    /**
     * Call an intent to start the email app
     */

    private fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target.toString()).matches()
    }
    @SuppressLint("IntentReset")
    fun sendEmail(recipient:String, message: String) { // do you need to change the parameters?

        // TODO: Use an intent to launch an email app.
        // TODO call createEmailMessage to generate the email message
        // TODO call startActivity(intent);
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.data = Uri.parse("mailto:")
        emailIntent.type = "text/plain"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Going on vacation!")
        emailIntent.putExtra(Intent.EXTRA_TEXT, message)
        startActivity(Intent.createChooser(emailIntent, "Choose Email"))
    }

    /**
     * Creates the string to send in the email message
     * @param name
     * @param city
     * @return the email message
     */
    private fun createEmailMessage(name: String, city: String): String {

        return getString(R.string.hey) + " " + name + " " + getString(R.string.im_going_to) + " " + city + "!"
    }

}