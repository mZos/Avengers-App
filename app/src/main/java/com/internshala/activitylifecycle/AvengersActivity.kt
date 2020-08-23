package com.internshala.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AvengersActivity : AppCompatActivity() {

    private lateinit var etMessage: EditText
    private lateinit var btnSend: Button
    private lateinit var btnLogOut: Button

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avengers)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val titleName = sharedPreferences.getString("Title", "The Avengers")

        title = titleName

        etMessage = findViewById(R.id.etMessage)
        btnSend = findViewById(R.id.btnSend)
        btnLogOut = findViewById(R.id.btnLogOut)

        btnSend.setOnClickListener {

            val intent = Intent(this@AvengersActivity, MessageActivity::class.java)
            intent.putExtra("Message", etMessage.text.toString())
            startActivity(intent)

            Toast.makeText(this@AvengersActivity, "Message Sent", Toast.LENGTH_LONG).show()
        }


        btnLogOut.setOnClickListener {

            startActivity(Intent(this@AvengersActivity, LoginActivity::class.java))
            Toast.makeText(this@AvengersActivity, "Logged Out Successfully", Toast.LENGTH_LONG).show()
            sharedPreferences.edit().clear().apply()
            finish()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}