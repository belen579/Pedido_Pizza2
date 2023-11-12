package com.example.pedido_pizza

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var botonvalidar: Button = findViewById(R.id.boton)

        val selectedIngredients = mutableListOf<String>()
        var ticketingredientes = ""

        var champiñones: CheckBox = findViewById(R.id.champiñones)
        var atun: CheckBox = findViewById(R.id.atun)
        var aceitunas: CheckBox = findViewById(R.id.aceitunas)
        var piña: CheckBox = findViewById(R.id.piña)
        var extra: CheckBox = findViewById(R.id.extra)
        var pepino: CheckBox = findViewById(R.id.checkBox)
        var ticket: TextView = findViewById(R.id.ticket)
        var recogidatienda: RadioButton = findViewById(R.id.recogida)
        var reparto: RadioButton = findViewById(R.id.reparto)
        var limpiar: Button = findViewById(R.id.limpiar)

        var cadena: String = "*"
        var toast: Toast? = null




        botonvalidar.setOnClickListener() {


            if (champiñones.isChecked) {
                selectedIngredients.add(ingredientes.champiñones.toString())


            } else {
                selectedIngredients.remove(ingredientes.champiñones.toString())
            }

            if (atun.isChecked) {
                selectedIngredients.add(ingredientes.atun.toString())

            } else {
                selectedIngredients.remove(ingredientes.atun.toString())
            }

            if (aceitunas.isChecked) {
                selectedIngredients.add(ingredientes.aceitunas.toString())


            } else {
                selectedIngredients.remove(ingredientes.aceitunas.toString())
            }
            if (piña.isChecked) {
                selectedIngredients.add(ingredientes.piña.toString())

            } else {
                selectedIngredients.remove(ingredientes.piña.toString())
            }

            if (extra.isChecked) {
                selectedIngredients.add(ingredientes.mozarella.toString())

            } else {
                selectedIngredients.remove(ingredientes.mozarella.toString())
            }

            if (pepino.isChecked) {
                selectedIngredients.add(ingredientes.pepino.toString())

            } else {
                selectedIngredients.remove(ingredientes.pepino.toString())
            }





            if (selectedIngredients.isNotEmpty()) {
                ticketingredientes =
                    "Ticket de pedido:\nIngredientes: ${selectedIngredients.joinToString(", ")}"
                ticket.text = ticketingredientes


            } else {
                ticket.text = "Ningún ingrediente seleccionado."
               // toast= Toast.makeText(this, "No ha marcado ningún ingrediente", Toast.LENGTH_SHORT)
            }


            if (reparto.isChecked) {


                ticket.text =
                         ticketingredientes + " \n Ha seleccionado: "+ " \n Reparto a domicilio"
            } else if( !reparto.isChecked && !recogidatienda.isChecked) {
                ticket.setTextColor(Color.WHITE)
                toast = Toast.makeText(this, "No ha marcado ningúna opción de recogida", Toast.LENGTH_SHORT)
                toast?.show()

                }

            if(recogidatienda.isChecked){
                ticket.setTextColor(Color.BLACK)
                ticket.text=
                        ticketingredientes + "\n Ha seleccionado:"+"\n Recogida en tienda"



                }else if( !reparto.isChecked && !recogidatienda.isChecked) {
                ticket.setTextColor(Color.WHITE)
                    toast =  Toast.makeText(this, "No ha marcado ningúna opción de recogida", Toast.LENGTH_SHORT)

                toast?.show()
            }







            limpiar.setOnClickListener() {
                champiñones.isChecked = false
                atun.isChecked = false
                aceitunas.isChecked = false
                extra.isChecked = false
                pepino.isChecked = false
                piña.isChecked = false
                reparto.isChecked= false
                recogidatienda.isChecked= false

                ticket.text = ""
                selectedIngredients.clear()
                toast?.cancel()

            }


            val ticketactivity2 =  ticket.text;
            val intent = Intent(this, MainActivity3::class.java);
            intent.putExtra("Ticket", ticketactivity2)
            startActivity(intent)






        }
    }

        enum class ingredientes {
            champiñones,
            pepino,
            piña,
            mozarella,
            aceitunas,
            atun


        }
    }







