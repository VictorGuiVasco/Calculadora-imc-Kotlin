package com.victor.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var btnCalc: Button
    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewsComponents()


        btnCalc.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)

            val weight = editWeight.text.toString()
            val height = editHeight.text.toString()

            if (weight.isNotEmpty() && height.isNotEmpty()){
                intent.putExtra("weight", weight.toDouble())
                intent.putExtra("height", height.toDouble())
            }

            startActivity(intent)
        }

    }

    private fun initViewsComponents() {
        btnCalc = findViewById(R.id.btn_calc)
        editWeight = findViewById(R.id.edit_weight)
        editHeight = findViewById(R.id.edit_height)
    }
}