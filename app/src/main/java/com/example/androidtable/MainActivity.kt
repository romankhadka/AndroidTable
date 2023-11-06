package com.example.androidtable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var androidVersionEditText: EditText
    private lateinit var codeNameEditText: EditText
    private lateinit var addButton: Button
    private lateinit var tableLayout: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        androidVersionEditText = findViewById(R.id.androidVersionEditText)
        codeNameEditText = findViewById(R.id.codeNameEditText)
        addButton = findViewById(R.id.addButton)
        tableLayout = findViewById(R.id.tableLayout)

        addRowToTable("Android 9.0", "Pie")
        addRowToTable("Android 8.0", "Oreo")

        addButton.setOnClickListener {
            val version = androidVersionEditText.text.toString()
            val codeName = codeNameEditText.text.toString()
            addRowToTable(version, codeName)
            androidVersionEditText.text.clear()
            codeNameEditText.text.clear()
        }
    }

    private fun addRowToTable(version: String, codeName: String) {
        val tableRow = TableRow(this)

        val versionCell = TextView(this)
        versionCell.text = version
        versionCell.setBackgroundResource(R.color.red)  // Set the background color to white (you can define this color in your resources)
        val versionCellParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)  // Set layout_weight to 1
        versionCell.layoutParams = versionCellParams

        val codeNameCell = TextView(this)
        codeNameCell.text = codeName
        codeNameCell.setBackgroundResource(R.color.red)  // Set the background color to white
        val codeNameCellParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)  // Set layout_weight to 1
        codeNameCell.layoutParams = codeNameCellParams

        val columnSeparator = View(this).apply {
            layoutParams = TableRow.LayoutParams(10, TableRow.LayoutParams.MATCH_PARENT)  // Add a 2px border between columns
            setBackgroundColor(resources.getColor(android.R.color.black))  // Set border color to black
        }

        tableRow.addView(versionCell)
        tableRow.addView(columnSeparator)
        tableRow.addView(codeNameCell)

        val rowParams = TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT)
        rowParams.setMargins(0, 10, 0, 0) // Add 10px margin between rows
        tableRow.layoutParams = rowParams
        tableLayout.addView(tableRow)
    }
}



