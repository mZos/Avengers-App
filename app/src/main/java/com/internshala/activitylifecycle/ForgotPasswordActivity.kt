package com.internshala.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var etForgotMobileNumber: EditText
    lateinit var etForgotPassword: EditText
    lateinit var btnResetPassword: Button

    private var validPhoneNumber = mutableListOf<String?>("0000000000", "1111111111", "8888888888")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        etForgotMobileNumber = findViewById(R.id.etForgotMobileNumber)
        etForgotPassword = findViewById(R.id.etForgotPassword)
        btnResetPassword = findViewById(R.id.btnResetPassword)



        btnResetPassword.setOnClickListener {
            val intent = Intent(this@ForgotPasswordActivity, LoginActivity::class.java)
            val phoneNumber = etForgotMobileNumber.text.toString()
            val password = etForgotPassword.text.toString()

            if (validPhoneNumber.contains(phoneNumber)) {
                intent.putExtra("Password", password)
                startActivity(intent)
                Toast.makeText( this@ForgotPasswordActivity,"Reset Password Successfully", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText( this@ForgotPasswordActivity,"Phone Number Not Registered", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}