package com.newdev.androidmaster.calculator


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
private var currentHeight: Int = 120
private var currentAge: Int = 30


private lateinit var viewMale: CardView
private lateinit var viewFemale: CardView
private lateinit var tvHeight: TextView
private lateinit var rsHeight: RangeSlider
private lateinit var btSubtractWeight: FloatingActionButton
private lateinit var btPlusWeight: FloatingActionButton
private lateinit var tvWeight: TextView
private lateinit var btSubtractAge: FloatingActionButton
private lateinit var btPlusAge: FloatingActionButton
private lateinit var tvAge: TextView
private lateinit var btnCalculate: Button



class CalculatorActivity : AppCompatActivity() {

    companion object{
        const val BMI_KEY = "BMI_RESULT"
    }
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
        setAge()
    }

    private fun initComponents(){
        viewMale= findViewById(R.id.ViewMan)
        viewFemale= findViewById(R.id.ViewFemale )
        tvHeight= findViewById(R.id.tvHeight)
        rsHeight=findViewById(R.id.rsHeight)
        btSubtractWeight=findViewById(R.id.btSubtractWeight)
        btPlusWeight=findViewById(R.id.btPlusWeight)
        tvWeight=findViewById(R.id.tvWeight)
        btSubtractAge=findViewById(R.id.btSubtractAge)
        btPlusAge=findViewById(R.id.btPlusAge)
        tvAge=findViewById(R.id.tvAge)
        btnCalculate=findViewById(R.id.btnCalculate)
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
            currentHeight = df.format(value).toInt()
            tvHeight.text = " $currentHeight cm"
        }
        btSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnCalculate.setOnClickListener {
            val result= calculateIMC()
            navegateToResult(result)
        }
    }

    private fun navegateToResult(result: Double) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(BMI_KEY, result)
        startActivity(intent)

    }

    private fun calculateIMC():Double {
        val df = DecimalFormat("#,##")
        val imc = currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        return df.format(imc).toDouble()
    }

    private fun setWeight(){
            tvWeight.text= currentWeight.toString()
        }
         private fun setAge(){
            tvAge.text= currentAge.toString()
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