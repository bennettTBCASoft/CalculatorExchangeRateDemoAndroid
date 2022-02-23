package com.example.calculateexchangeratedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import org.w3c.dom.Text
import java.text.DecimalFormat
import kotlin.math.round

class CalculateExchangeRatePage : AppCompatActivity(), TextWatcher {
    private lateinit var jpyET:EditText
    private lateinit var twdET:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_exchange_rate_page)

        jpyET = findViewById(R.id.editText1)
        twdET = findViewById(R.id.editText2)

        val type1TV = findViewById<TextView>(R.id.textView6)
        val exchangeTV = findViewById<TextView>(R.id.textView7)
        val type2TV = findViewById<TextView>(R.id.textView8)
        var changeBool: Boolean = true
        val switchBtn = findViewById<ImageButton>(R.id.imageButton)



        // initalized
        jpyET.text.clear()
        twdET.text.clear()

        // 交換幣別按鈕
        switchBtn.setOnClickListener {
            if (changeBool) {
                type1TV.text = "TWD"
                type2TV.text = "JPY"
                exchangeTV.text = "4.13"
                changeBool = false
            } else {
                type1TV.text = "JPY"
                type2TV.text = "TWD"
                exchangeTV.text = "0.24135"
                changeBool = true
            }
        }
        jpyET.addTextChangedListener(this)
    }


    fun clickNumber(view: View) {
        when (view.tag) {
            "1" -> jpyET.text.append("1")
            "2" -> jpyET.text.append("2")
            "3" -> jpyET.text.append("3")
            "4" -> jpyET.text.append("4")
            "5" -> jpyET.text.append("5")
            "6" -> jpyET.text.append("6")
            "7" -> jpyET.text.append("7")
            "8" -> jpyET.text.append("8")
            "9" -> jpyET.text.append("9")
            "0" -> {
                if (jpyET.text.isNullOrEmpty()) {
                    return
                }
                jpyET.text.append("0")
            }
            "clean" -> jpyET.text.clear()
            "delete" -> {
                if(jpyET.text.isNullOrEmpty()) {
                    return
                }
                jpyET.text.delete(jpyET.text.length-1, jpyET.text.length)
            }
            else -> println("default")
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        println("onTextChanged")
        if (jpyET.text.isNullOrEmpty()){
            twdET.text.clear()
            return
        }
        var jpyNumber: Double = jpyET.text.toString().toDouble()
        var twdNumber: Double = round(jpyNumber * 0.24135)

//        var df = DecimalFormat("###################")
        var df = DecimalFormat("0")
        twdET.setText(df.format(twdNumber))

    }

    override fun afterTextChanged(p0: Editable?) {

    }


}

