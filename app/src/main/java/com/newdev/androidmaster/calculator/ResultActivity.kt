package com.newdev.androidmaster.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.newdev.androidmaster.R
import com.newdev.androidmaster.calculator.CalculatorActivity.Companion.BMI_KEY

class ResultActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvBMI: TextView
    private lateinit var tvDescreption: TextView
    private lateinit var btnRecalculate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.extras?.getDouble(BMI_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }
    private fun initListeners() {
        btnRecalculate.setOnClickListener {
            onBackPressed()
        }
    }
    private fun initUI(result: Double) {

        tvBMI.text = result.toString()

        when (result) {
            in 0.0..18.50 -> { //less

                tvResult.text = getString(R.string.title_under_weight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.under_weight))
                tvDescreption.text = getString(R.string.description_under_weight)

            }
            in 18.51..24.99 -> {  //normal

                tvResult.text = getString(R.string.title_normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
                tvDescreption.text = getString(R.string.description_normal)
            }
            in 25.00..29.99 -> {  //more

                tvResult.text = getString(R.string.title_overweight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.overweight))
                tvDescreption.text = getString(R.string.description_overweight)
            }
            in 30.00..99.99 -> {  //besidad

                tvResult.text = getString(R.string.title_obesity)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesity))
                tvDescreption.text = getString(R.string.description_obesity)
            }
            else -> { //erro
                tvBMI.text = getString(R.string.msg_erro)
                tvResult.text = getString(R.string.msg_erro)
                tvDescreption.text = getString(R.string.msg_erro)
            }
        }

    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvBMI = findViewById(R.id.tvbmi)
        tvDescreption = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnReCalculate)

    }
}