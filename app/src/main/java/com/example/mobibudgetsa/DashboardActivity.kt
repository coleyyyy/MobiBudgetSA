package com.example.mobibudgetsa

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class DashboardActivity : AppCompatActivity() {

    private lateinit var welcomeTextView: TextView
    private lateinit var balanceTextView: TextView
    private lateinit var incomeTextView: TextView
    private lateinit var expensesTextView: TextView
    private lateinit var budgetTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashboard)

        welcomeTextView = findViewById(R.id.welcomeTextView)
        balanceTextView = findViewById(R.id.balanceTextView)
        incomeTextView = findViewById(R.id.incomeTextView)
        expensesTextView = findViewById(R.id.expensesTextView)
        budgetTextView = findViewById(R.id.budgetTextView)

        val addTransactionButton =
            findViewById<Button>(R.id.addTransactionButton)

        val viewTransactionsButton =
            findViewById<Button>(R.id.viewTransactionsButton)

        val budgetButton =
            findViewById<Button>(R.id.budgetButton)

        val reportsButton = findViewById<Button>(R.id.reportsButton)

        val settingsButton =
            findViewById<Button>(R.id.settingsButton)

        welcomeTextView.text = "Welcome to MobiBudget SA"
        balanceTextView.text = "R 0.00"
        incomeTextView.text = "Income: R 0.00"
        expensesTextView.text = "Expenses: R 0.00"
        budgetTextView.text = "Budget Used: R 0.00"

        addTransactionButton.setOnClickListener {
            val intent = Intent(this, AddTransactionActivity::class.java)
            startActivity(intent)
        }

        viewTransactionsButton.setOnClickListener {
            val intent = Intent(this, TransactionsActivity::class.java)
            startActivity(intent)
        }
            // Transaction list will be connected next


        budgetButton.setOnClickListener {
            val intent = Intent(this, BudgetActivity::class.java)
            startActivity(intent)
        }
            // Budget screen will be connected next

        reportsButton.setOnClickListener {
            val intent = Intent(this, ReportsActivity::class.java)
            startActivity(intent)

            settingsButton.setOnClickListener {

                val intent =
                    Intent(
                        this,
                        SettingsActivity::class.java
                    )

                startActivity(intent)
            }
        }
        }
    }
