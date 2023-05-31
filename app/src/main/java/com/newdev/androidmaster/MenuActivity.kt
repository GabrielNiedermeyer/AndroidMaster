package com.newdev.androidmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludApp = findViewById<Button>(R.id.btn)
        val btnImcApp = findViewById<Button>(R.id.btnImcApp)
        btnSaludApp.setOnClickListener { navegateToSaludApp }
    }
    private fun navegateToSaludApp(){
        val intent = Intent ( this, MenuActivity::class.java)


    }
}