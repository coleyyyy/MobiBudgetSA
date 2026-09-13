package com.example.mobibudgetsa

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mobibudgetsa.data.DatabaseProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReportsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports)

        val totalIncomeTextView =
            findViewById<TextView>(R.id.totalIncomeTextView)

        val totalExpensesTextView =
            findViewById<TextView>(R.id.totalExpensesTextView)

        val balanceReportTextView =
            findViewById<TextView>(R.id.balanceReportTextView)

        val reportSummaryTextView =
            findViewById<TextView>(R.id.reportSummaryTextView)

        val database =
            DatabaseProvider.getDatabase(applicationContext)

        CoroutineScope(Dispatchers.IO).launch {

            val transactions =
                database.transactionDao().getAllTransactions()

            var income = 0.0
            var expenses = 0.0

            transactions.forEach { transaction ->

                if (transaction.type.equals("Income", ignoreCase = true)) {
                    income += transaction.amount
                } else {
                    expenses += transaction.amount
                }
            }

            val balance = income - expenses

            withContext(Dispatchers.Main) {

                totalIncomeTextView.text =
                    "Total Income: R %.2f".format(income)

                totalExpensesTextView.text =
                    "Total Expenses: R %.2f".format(expenses)

                balanceReportTextView.text =
                    "Balance: R %.2f".format(balance)

                reportSummaryTextView.text =
                    "Spending Summary\n\n" +
                            "Transactions recorded: ${transactions.size}\n" +
                            "Income: R %.2f\n".format(income) +
                            "Expenses: R %.2f".format(expenses)
            }
        }
    }
}