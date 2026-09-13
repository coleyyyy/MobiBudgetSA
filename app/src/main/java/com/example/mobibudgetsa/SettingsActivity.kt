package com.example.mobibudgetsa

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val languageSpinner =
            findViewById<Spinner>(R.id.languageSpinner)

        val currencySpinner =
            findViewById<Spinner>(R.id.currencySpinner)

        val notificationsSwitch =
            findViewById<Switch>(R.id.notificationsSwitch)

        val saveSettingsButton =
            findViewById<Button>(R.id.saveSettingsButton)

        val logoutButton =
            findViewById<Button>(R.id.logoutButton)

        val languages = arrayOf(
            "English",
            "isiXhosa",
            "isiZulu"
        )

        val currencies = arrayOf(
            "ZAR - South African Rand",
            "USD - US Dollar",
            "EUR - Euro"
        )

        languageSpinner.adapter =
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                languages
            )

        currencySpinner.adapter =
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                currencies
            )

        val preferences =
            getSharedPreferences(
                "MobiBudgetSettings",
                MODE_PRIVATE
            )

        val savedLanguage =
            preferences.getString(
                "language",
                "English"
            )

        val savedCurrency =
            preferences.getString(
                "currency",
                "ZAR - South African Rand"
            )

        val notificationsEnabled =
            preferences.getBoolean(
                "notifications",
                true
            )

        languageSpinner.setSelection(
            languages.indexOf(savedLanguage)
                .coerceAtLeast(0)
        )

        currencySpinner.setSelection(
            currencies.indexOf(savedCurrency)
                .coerceAtLeast(0)
        )

        notificationsSwitch.isChecked =
            notificationsEnabled

        saveSettingsButton.setOnClickListener {

            val selectedLanguage =
                languageSpinner.selectedItem.toString()

            val selectedCurrency =
                currencySpinner.selectedItem.toString()

            val notifications =
                notificationsSwitch.isChecked

            preferences.edit()
                .putString(
                    "language",
                    selectedLanguage
                )
                .putString(
                    "currency",
                    selectedCurrency
                )
                .putBoolean(
                    "notifications",
                    notifications
                )
                .apply()

            Toast.makeText(
                this,
                "Settings saved successfully.",
                Toast.LENGTH_SHORT
            ).show()
        }

        logoutButton.setOnClickListener {

            FirebaseAuth.getInstance().signOut()

            Toast.makeText(
                this,
                "Logged out successfully.",
                Toast.LENGTH_SHORT
            ).show()

            val intent =
                Intent(
                    this,
                    LoginActivity::class.java
                )

            intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
            finish()
        }
    }
}