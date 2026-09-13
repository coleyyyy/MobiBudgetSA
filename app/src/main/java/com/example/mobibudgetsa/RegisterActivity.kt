package com.example.mobibudgetsa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var registerButton: Button

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Connect the Firebase Authentication service
        firebaseAuth = FirebaseAuth.getInstance()

        // Connect the XML fields to Kotlin
        firstNameEditText = findViewById(R.id.firstNameEditText)
        lastNameEditText = findViewById(R.id.lastNameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText)
        registerButton = findViewById(R.id.registerButton)

        // Register button
        registerButton.setOnClickListener {
            validateRegistration()
        }
    }

    private fun validateRegistration() {

        val firstName = firstNameEditText.text.toString().trim()
        val lastName = lastNameEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString()
        val confirmPassword = confirmPasswordEditText.text.toString()

        // Check first name
        if (firstName.isEmpty()) {
            firstNameEditText.error = "Please enter your first name"
            firstNameEditText.requestFocus()
            return
        }

        // Check last name
        if (lastName.isEmpty()) {
            lastNameEditText.error = "Please enter your last name"
            lastNameEditText.requestFocus()
            return
        }

        // Check email
        if (email.isEmpty()) {
            emailEditText.error = "Please enter your email"
            emailEditText.requestFocus()
            return
        }

        // Check email format
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.error = "Please enter a valid email"
            emailEditText.requestFocus()
            return
        }

        // Check password
        if (password.isEmpty()) {
            passwordEditText.error = "Please enter a password"
            passwordEditText.requestFocus()
            return
        }

        // Check password length
        if (password.length < 6) {
            passwordEditText.error = "Password must be at least 6 characters"
            passwordEditText.requestFocus()
            return
        }

        // Check confirmation password
        if (confirmPassword.isEmpty()) {
            confirmPasswordEditText.error = "Please confirm your password"
            confirmPasswordEditText.requestFocus()
            return
        }

        // Check that passwords match
        if (password != confirmPassword) {
            confirmPasswordEditText.error = "Passwords do not match"
            confirmPasswordEditText.requestFocus()
            return
        }

        // Create the Firebase Authentication account
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {

                    Toast.makeText(
                        this,
                        "Account created successfully",
                        Toast.LENGTH_SHORT
                    ).show()

                    // Go back to the Login screen
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {

                    Toast.makeText(
                        this,
                        "Registration failed: ${task.exception?.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }
}