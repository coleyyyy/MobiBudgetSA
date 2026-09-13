package com.example.mobibudgetsa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobibudgetsa.data.DatabaseProvider
import com.example.mobibudgetsa.model.Transaction
import com.example.mobibudgetsa.repository.TransactionRepository
import com.example.mobibudgetsa.ui.viewmodel.TransactionViewModel

class AddTransactionActivity : AppCompatActivity() {

    private lateinit var transactionViewModel: TransactionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_transaction)

        val amountEditText =
            findViewById<EditText>(R.id.amountEditText)

        val categoryEditText =
            findViewById<EditText>(R.id.categoryEditText)

        val dateEditText =
            findViewById<EditText>(R.id.dateEditText)

        val descriptionEditText =
            findViewById<EditText>(R.id.descriptionEditText)

        val incomeRadioButton =
            findViewById<RadioButton>(R.id.incomeRadioButton)

        val saveButton =
            findViewById<Button>(R.id.saveTransactionButton)

        // Connect the ViewModel to the Room database.
        val database =
            DatabaseProvider.getDatabase(applicationContext)

        val repository =
            TransactionRepository(database.transactionDao())

        transactionViewModel =
            TransactionViewModel(repository)

        saveButton.setOnClickListener {

            val amountText =
                amountEditText.text.toString().trim()

            val categoryText =
                categoryEditText.text.toString().trim()

            val dateText =
                dateEditText.text.toString().trim()

            val descriptionText =
                descriptionEditText.text.toString().trim()

            // Check required fields.
            if (amountText.isEmpty() ||
                categoryText.isEmpty() ||
                dateText.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Please complete all required fields.",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            // Convert amount to a number.
            val amount =
                amountText.toDoubleOrNull()

            if (amount == null || amount <= 0) {

                Toast.makeText(
                    this,
                    "Please enter a valid amount.",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val transactionType =
                if (incomeRadioButton.isChecked) {
                    "Income"
                } else {
                    "Expense"
                }

            val transaction =
                Transaction(
                    transactionId = System.currentTimeMillis().toInt(),
                    userId = 1,
                    amount = amount,
                    type = transactionType,
                    categoryId = 1,
                    transactionDate = dateText,
                    description = descriptionText,
                    synced = false
                )

            // Save the transaction through the ViewModel.
            transactionViewModel.addTransaction(transaction)

            Toast.makeText(
                this,
                "Transaction saved successfully.",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}