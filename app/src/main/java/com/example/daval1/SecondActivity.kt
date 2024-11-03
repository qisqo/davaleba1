package com.example.daval1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val recipientEmailText = findViewById<TextView>(R.id.recipientEmailText)
        val messageText = findViewById<TextView>(R.id.messageText)
        val clearButton = findViewById<Button>(R.id.clearButton)

        val recipientEmail = intent.getStringExtra("recipientEmail") ?: "No recipient email provided"
        val message = intent.getStringExtra("message") ?: "No message provided"

        recipientEmailText.text = recipientEmail
        messageText.text = message

        clearButton.setOnClickListener {
            recipientEmailText.text = ""
            messageText.text = ""
            Toast.makeText(this, "Cleared successfully", Toast.LENGTH_SHORT).show()
        }
    }
}
