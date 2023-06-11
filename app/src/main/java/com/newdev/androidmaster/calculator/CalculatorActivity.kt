package com.newdev.androidmaster.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.slider.RangeSlider
import com.newdev.androidmaster.R
import java.text.DecimalFormat

private var isMaleSelected:Boolean =  true
private var isFemaleSelected:Boolean = false


private lateinit var viewMale: CardView
private lateinit var viewFemale: CardView
private lateinit var tvHeight: TextView
private lateinit var rsHeight: RangeSlider
class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        initComponents()
        unitListener()
        unitUI()
    }

    private fun unitUI() {
    setGenderColor()
    }

    private fun initComponents(){
        viewMale= findViewById(R.id.ViewMan)
        viewFemale= findViewById(R.id.ViewFemale )
        tvHeight= findViewById(R.id.tvHeight)
        rsHeight=findViewById(R.id.rsHeight)
    }

    private fun unitListener() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result= df.format(value)
            tvHeight.text="$result cm"
        }
    }
    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }
    private fun setGenderColor(){
       viewMale.setCardBackgroundColor(getBackGroundColor(isMaleSelected))
       viewFemale.setCardBackgroundColor(getBackGroundColor(isFemaleSelected))
    }

    private fun getBackGroundColor(isSeletedComponent: Boolean):Int {
        val colorReference = if(isSeletedComponent){
            R.color.background_component_selected
        }else{
            R.color.background_component
        }
        return  ContextCompat.getColor(this, colorReference )
    }

}