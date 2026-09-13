package com.example.mobibudgetsa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BudgetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget)

        val categoryEditText = findViewById<EditText>(R.id.categoryEditText)
        val amountEditText = findViewById<EditText>(R.id.budgetAmountEditText)
        val saveButton = findViewById<Button>(R.id.saveBudgetButton)
        val statusTextView = findViewById<TextView>(R.id.budgetStatusTextView)

        saveButton.setOnClickListener {

            val category = categoryEditText.text.toString().trim()
            val amountText = amountEditText.text.toString().trim()

            if (category.isEmpty() || amountText.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please enter a category and amount.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val amount = amountText.toDoubleOrNull()

            if (amount == null || amount <= 0) {
                Toast.makeText(
                    this,
                    "Please enter a valid budget amount.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            statusTextView.text =
                "Monthly Budget\n\nCategory: $category\nBudget: R %.2f".format(amount)

            Toast.makeText(
                this,
                "Budget saved successfully.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}