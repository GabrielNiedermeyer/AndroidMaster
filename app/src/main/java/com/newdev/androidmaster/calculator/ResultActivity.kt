package com.newdev.androidmaster.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.newdev.androidmaster.R
import com.newdev.androidmaster.calculator.CalculatorActivity.Companion.IMC_KEY

class ResultActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescreption: TextView
    private lateinit var btnRecalculate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0
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

        tvIMC.text = result.toString()

        when (result) {
            in 0.0..18.50 -> { //less

                tvResult.text = getString(R.string.title_less)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.less_weight))
                tvDescreption.text = getString(R.string.description_less)

            }
            in 18.51..24.99 -> {  //normal

                tvResult.text = getString(R.string.title_normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
                tvDescreption.text = getString(R.string.description_normal)
            }
            in 25.00..29.99 -> {  //more

                tvResult.text = getString(R.string.title_more)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.more_weight))
                tvDescreption.text = getString(R.string.description_more)
            }
            in 30.00..99.99 -> {  //besidad

                tvResult.text = getString(R.string.title_obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvDescreption.text = getString(R.string.description_obesidade)
            }
            else -> { //erro
                tvIMC.text = getString(R.string.msg_erro)
                tvResult.text = getString(R.string.msg_erro)
                tvDescreption.text = getString(R.string.msg_erro)
            }
        }

    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescreption = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnReCalculate)

    }
}