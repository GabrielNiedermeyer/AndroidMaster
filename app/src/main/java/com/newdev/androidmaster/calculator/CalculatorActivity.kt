package com.newdev.androidmaster.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.newdev.androidmaster.R

private var isMaleSelected:Boolean =  true
private var isFemaleSelected:Boolean = false


private lateinit var viewMale: CardView
private lateinit var viewFemale: CardView
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