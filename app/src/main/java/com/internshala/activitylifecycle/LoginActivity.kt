package com.internshala.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogIn: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    val validPassword = mutableListOf("tony", "hulk", "captain", "thor")
    val validPhoneNumber = mutableListOf("0000000000", "1111111111", "8888888888")

    private lateinit var sharedPreferences: SharedPreferences
    lateinit var getPassword: String


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        setContentView(R.layout.activity_login)


        if (isLoggedIn) {
            intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()

        }

        if (intent != null) {
            getPassword = intent.getStringExtra("Password").toString()
            println("$getPassword Test")

            validPassword.add(getPassword)
        }

        println("$validPassword valid passwords2")

        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogIn = findViewById(R.id.btnLogIn)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)
        btnLogIn.setOnClickListener {

            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            val phoneNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            var avengerName = ""

            if (validPhoneNumber.contains(phoneNumber)) {
                when (password) {
                    validPassword[0] -> {
                        avengerName = "Tony Stark"
                        setPreference(avengerName)
                        Toast.makeText(
                            this@LoginActivity,
                            "Hello! ${avengerName}, Welcome to the Team Avengers",
                            Toast.LENGTH_SHORT
                        ).show()
                        startActivity(intent)

                    }

                    validPassword[1] -> {
                        avengerName = "Dr. Bruce Banner"
                        setPreference(avengerName)
                        Toast.makeText(
                            this@LoginActivity,
                            "Hello! ${avengerName}, Welcome to the Team Avengers",
                            Toast.LENGTH_SHORT
                        ).show()
                        startActivity(intent)

                    }

                    validPassword[2] -> {
                        avengerName = "Steve Rogers"
                        setPreference(avengerName)
                        Toast.makeText(
                            this@LoginActivity,
                            "Hello! ${avengerName}, Welcome to the Team Avengers",
                            Toast.LENGTH_SHORT
                        ).show()
                        startActivity(intent)

                    }

                    validPassword[3] -> {
                        avengerName = "Thor Odinson"
                        setPreference(avengerName)
                        intent.putExtra("name", avengerName)
                        Toast.makeText(
                            this@LoginActivity,
                            "Hello! ${avengerName}, Welcome to the Team Avengers",
                            Toast.LENGTH_SHORT
                        ).show()
                        startActivity(intent)

                    }


                    else -> {
                        if (validPassword.contains(password)) {
                            Toast.makeText(
                                this@LoginActivity,
                                "Login Successful",
                                Toast.LENGTH_SHORT
                            ).show()
                            finish()
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                this@LoginActivity,
                                "Invalid Password",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            } else {
                Toast.makeText(this@LoginActivity, "Invalid Phone Number", Toast.LENGTH_LONG)
                    .show()

            }
        }

        txtForgotPassword.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
        }

        txtRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
    }

    private fun setPreference(title: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }
}