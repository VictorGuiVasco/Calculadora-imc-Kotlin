package com.victor.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.math.BigDecimal
import java.math.RoundingMode

class ResultActivity : AppCompatActivity() {
    private lateinit var textHeight: TextView
    private lateinit var textWeight: TextView
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        initViewsComponents()

        val bundle = intent.extras
        if (bundle != null) {
            val weight = bundle.getDouble("weight")
            val height = bundle.getDouble("height")

            val bmi = calBMI(weight, height)

            val result = if (bmi < 18.5) {
                "Baixo"
            } else if (bmi in 18.5..24.9) {
                "Normal"
            } else if (bmi in 25.0..29.9) {
                "Sobrepeso"
            } else {
                "Obeso"
            }

            textWeight.text = "Peso informado: $weight" + "kg"
            textHeight.text = "Altura informada: $height" + "m"
            textResult.text = "$bmi: $result"
        }
    }

    private fun initViewsComponents() {
        textHeight = findViewById(R.id.text_height)
        textWeight = findViewById(R.id.text_weight)
        textResult = findViewById(R.id.text_result)
    }

    private fun calBMI(weight: Double, height: Double): Double {
        val bmi = weight / (height * height)
        val bmiFormatted = BigDecimal(bmi).setScale(1, RoundingMode.HALF_EVEN)
        return bmiFormatted.toDouble()
    }

}