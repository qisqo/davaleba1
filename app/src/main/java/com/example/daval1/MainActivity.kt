package com.example.daval1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userEmail = findViewById<EditText>(R.id.fromEmail)
        val recipientEmail = findViewById<EditText>(R.id.toEmail)
        val message = findViewById<EditText>(R.id.message)
        val sendButton = findViewById<Button>(R.id.sendButton)

        sendButton.setOnClickListener {
            val user = userEmail.text.toString().trim()
            val recipient = recipientEmail.text.toString().trim()
            val msg = message.text.toString().trim()

            if (user.isEmpty() || recipient.isEmpty() || msg.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!user.contains("@") || !recipient.contains("@")) {
                Toast.makeText(this, "Enter valid email addresses", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (msg.length > 250) {
                Toast.makeText(this, "Message should be 250 characters or less", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("recipientEmail", recipient)
                putExtra("message", msg)
            }
            startActivity(intent)
        }
    }
}
