package com.newdev.androidmaster.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.newdev.androidmaster.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result= intent.extras?.getDouble("IMC_RESULT")?: -1
    }
}