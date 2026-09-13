package com.example.mobibudgetsa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobibudgetsa.data.DatabaseProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TransactionsActivity : AppCompatActivity() {

    private lateinit var container: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transactions)

        container = findViewById(R.id.transactionsContainer)

        loadTransactions()
    }

    private fun loadTransactions() {

        val database = DatabaseProvider.getDatabase(applicationContext)

        CoroutineScope(Dispatchers.IO).launch {

            val transactions = database.transactionDao().getAllTransactions()

            withContext(Dispatchers.Main) {

                container.removeAllViews()

                if (transactions.isEmpty()) {

                    val emptyText = TextView(this@TransactionsActivity)

                    emptyText.text = "No transactions found."
                    emptyText.textSize = 18f

                    container.addView(emptyText)

                } else {

                    transactions.forEach { transaction ->

                        val transactionLayout =
                            LinearLayout(this@TransactionsActivity)

                        transactionLayout.orientation =
                            LinearLayout.VERTICAL

                        transactionLayout.setPadding(0, 0, 0, 32)

                        val transactionText =
                            TextView(this@TransactionsActivity)

                        transactionText.text =
                            "Type: ${transaction.type}\n" +
                                    "Amount: R %.2f\n".format(transaction.amount) +
                                    "Date: ${transaction.transactionDate}\n" +
                                    "Description: ${transaction.description}"

                        transactionText.textSize = 18f

                        val editButton =
                            Button(this@TransactionsActivity)

                        editButton.text = "Edit"

                        val deleteButton =
                            Button(this@TransactionsActivity)

                        deleteButton.text = "Delete"

                        editButton.setOnClickListener {

                            val intent = Intent(
                                this@TransactionsActivity,
                                AddTransactionActivity::class.java
                            )

                            intent.putExtra(
                                "transactionId",
                                transaction.transactionId
                            )

                            startActivity(intent)
                        }

                        deleteButton.setOnClickListener {

                            CoroutineScope(Dispatchers.IO).launch {

                                database.transactionDao()
                                    .deleteTransaction(transaction)

                                withContext(Dispatchers.Main) {

                                    Toast.makeText(
                                        this@TransactionsActivity,
                                        "Transaction deleted.",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    loadTransactions()
                                }
                            }
                        }

                        transactionLayout.addView(transactionText)
                        transactionLayout.addView(editButton)
                        transactionLayout.addView(deleteButton)

                        container.addView(transactionLayout)
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loadTransactions()
    }
}