package com.example.pedido_pizza

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        val intent = intent

        val textorecibido = intent.getStringExtra("Ticket")



        val textview  = findViewById<TextView>(R.id.ticketfinal)
        textview.text = textorecibido
    }
}