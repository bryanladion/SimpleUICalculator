package com.newproject.simpleuicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.EditText
import android.widget.TextView
import android.os.Build
import android.view.WindowManager
import android.widget.Toast
import android.media.MediaPlayer
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setting up transparent.translucent status bar as well as full screen background
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT) getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        val layout= findViewById<ConstraintLayout>(R.id.backGround)
        val switch= findViewById<ImageView>(R.id.light_switch)
        val clickme= findViewById<ImageView>(R.id.light_clickme)
        val plus = findViewById<ImageView>(R.id.light_plus)
        val minus = findViewById<ImageView>(R.id.light_minus)
        val devide = findViewById<ImageView>(R.id.light_devide)
        val times = findViewById<ImageView>(R.id.light_times)
        val modulos = findViewById<ImageView>(R.id.light_modulos)
        var count = 1
        switch.setOnClickListener {
            count += 1
            if (count % 2 == 0) {
                layout.setBackgroundResource(R.drawable.dark_background)
                switch.setImageResource(R.drawable.dark_switch)
                clickme.setImageResource(R.drawable.dark_clickme)
                plus.setImageResource(R.drawable.dark_plus)
                minus.setImageResource(R.drawable.dark_minus)
                devide.setImageResource(R.drawable.dark_devide)
                times.setImageResource(R.drawable.dark_times)
                modulos.setImageResource(R.drawable.dark_modulos)
            } else {
                layout.setBackgroundResource(R.drawable.light_background)
                switch.setImageResource(R.drawable.light_switch)
                clickme.setImageResource(R.drawable.light_clickme)
                plus.setImageResource(R.drawable.light_plus)
                minus.setImageResource(R.drawable.light_minus)
                devide.setImageResource(R.drawable.light_devide)
                times.setImageResource(R.drawable.light_times)
                modulos.setImageResource(R.drawable.light_modulos)
            }
        }
            // CALCULATOR LOGIC
          val firstnum = findViewById<EditText>(R.id.firstNumber)
          val secondnum = findViewById<EditText>(R.id.secondNumber)
          val answer = findViewById<TextView>(R.id.print_answer)

            var num1 : Int
            var num2 : Int
            var result :Int

            plus.setOnClickListener{
              num1=Integer.parseInt(firstnum.getText().toString())
                num2=Integer.parseInt(secondnum.getText().toString())
                result = num1+num2
                answer.setText(result.toString())
            }

        minus.setOnClickListener{
            num1=Integer.parseInt(firstnum.getText().toString())
            num2=Integer.parseInt(secondnum.getText().toString())
            result = num1-num2
            answer.setText(result.toString())
        }
        devide.setOnClickListener{
            num1=Integer.parseInt(firstnum.getText().toString())
            num2=Integer.parseInt(secondnum.getText().toString())
            result = num1/num2
            answer.setText(result.toString())
        }
        times.setOnClickListener{
            num1=Integer.parseInt(firstnum.getText().toString())
            num2=Integer.parseInt(secondnum.getText().toString())
            result = num1*num2
            answer.setText(result.toString())
        }
        modulos.setOnClickListener{
            num1=Integer.parseInt(firstnum.getText().toString())
            num2=Integer.parseInt(secondnum.getText().toString())
            result = num1%num2
            answer.setText(result.toString())
        }

    //making a toast and adding audio on click me button
        val mediaplayer = MediaPlayer.create(this,R.raw.clickme_audio)
        clickme.setOnClickListener{
            Toast.makeText(applicationContext,"Bryan B. Ladion",Toast.LENGTH_LONG).show()
            mediaplayer.start()
        }

    }
}