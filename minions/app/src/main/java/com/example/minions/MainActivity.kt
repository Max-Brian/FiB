package com.example.minions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        zeroBTN.setOnClickListener { appendVal("0", false) }
        oneBTN.setOnClickListener { appendVal("1", false) }
        twoBTN.setOnClickListener { appendVal("2", false) }
        twoBTN.setOnClickListener { appendVal("3", false) }
        twoBTN.setOnClickListener { appendVal("4", false) }
        twoBTN.setOnClickListener { appendVal("5", false) }
        twoBTN.setOnClickListener { appendVal("6", false) }
        twoBTN.setOnClickListener { appendVal("7", false) }
        twoBTN.setOnClickListener { appendVal("8", false) }
        twoBTN.setOnClickListener { appendVal("9", false) }
        twoBTN.setOnClickListener { appendVal(".", false) }
        //Operators
        clearBTN().setOnClickListener { appendVal("", true) }
        startBracket.setOnClickListener { appendVal(" ( ", false) }
        closeBracket.setOnClickListener { appendVal(" ) ", false) }
        divideBTN.setOnClickListener { appendVal(" / ", false) }
        multiplyBTN.setOnClickListener { appendVal(" * ", false) }
        minusBTN.setOnClickListener { appendVal(" - ", false) }
        addBTN.setOnClickListener { appendVal(" + ", false) }

        actionBack.setOnClickListener {
            val expression = placeholder.text.toString()
            if (expression.isNotEmpty()) {
                placeholder.text = expression.substring(0, expression.length - 1)
            }


        }

        actionEquals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(placeholder.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    Toast.makeText(this, "Double", Toast.LENGTH_SHORT).show()
                    answer.text = longResult.toString()
                } else
                    answer.text = result.toString()

            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show();

                Log.d("EXCEPTION", "Message: ${e.message}")
            }

        }


    }

    fun appendVal(string: String, isClear: Boolean) {
        if (isClear) {
            placeholder.text = ""
            answer.text = ""
//            placeholder.append(string)
        } else {
            placeholder.append(string)
        }
    }

}











