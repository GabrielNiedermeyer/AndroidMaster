package com.newdev.androidmaster.calculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.newdev.androidmaster.R
import java.text.DecimalFormat

private var isMaleSelected:Boolean =  true
private var isFemaleSelected:Boolean = false
private var currentWeight: Int = 60


private lateinit var viewMale: CardView
private lateinit var viewFemale: CardView
private lateinit var tvHeight: TextView
private lateinit var rsHeight: RangeSlider
private lateinit var btSubtractWeight: FloatingActionButton
private lateinit var btPlusWeight: FloatingActionButton
private lateinit var tvWeight: TextView

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
        setWeight()
    }

    private fun initComponents(){
        viewMale= findViewById(R.id.ViewMan)
        viewFemale= findViewById(R.id.ViewFemale )
        tvHeight= findViewById(R.id.tvHeight)
        rsHeight=findViewById(R.id.rsHeight)
        btSubtractWeight=findViewById(R.id.btSubtractWeight)
        btPlusWeight=findViewById(R.id.btPlusWeight)
        tvWeight=findViewById(R.id.tvWeight)
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
            val result = df.format(value)
            tvHeight.text = "$result cm"
        }
        btSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
    }
        private fun setWeight(){
            tvWeight.text= currentWeight.toString()
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