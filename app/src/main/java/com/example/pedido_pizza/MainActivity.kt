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
import androidx.appcompat.app.AlertDialog

import com.example.pedido_pizza.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val selectedIngredients = mutableListOf<String>()
        var ticketingredientes = ""
        var toast: Toast? = null

        binding.boton.setOnClickListener() {


            if (binding.champiOnes.isChecked) {
                selectedIngredients.add(ingredientes.champiñones.toString())


            } else {
                selectedIngredients.remove(ingredientes.champiñones.toString())
            }

            if (binding.atun.isChecked) {
                selectedIngredients.add(ingredientes.atun.toString())

            } else {
                selectedIngredients.remove(ingredientes.atun.toString())
            }

            if (binding.aceitunas.isChecked) {
                selectedIngredients.add(ingredientes.aceitunas.toString())


            } else {
                selectedIngredients.remove(ingredientes.aceitunas.toString())
            }
            if (binding.piA.isChecked) {
                selectedIngredients.add(ingredientes.piña.toString())

            } else {
                selectedIngredients.remove(ingredientes.piña.toString())
            }

            if (binding.extra.isChecked) {
                selectedIngredients.add(ingredientes.mozarella.toString())

            } else {
                selectedIngredients.remove(ingredientes.mozarella.toString())
            }

            if (binding.pepino.isChecked) {
                selectedIngredients.add(ingredientes.pepino.toString())

            } else {
                selectedIngredients.remove(ingredientes.pepino.toString())
            }




            if (selectedIngredients.isNotEmpty()) {
                ticketingredientes =
                    "Ticket de pedido:\nIngredientes: ${selectedIngredients.joinToString(", ")}"
                binding.ticket.text = ticketingredientes


            } else {
                binding.ticket.text = "Ningún ingrediente seleccionado."
               // toast= Toast.makeText(this, "No ha marcado ningún ingrediente", Toast.LENGTH_SHORT)
            }


            if (binding.reparto.isChecked) {


                binding.ticket.text =
                         ticketingredientes + " \n Ha seleccionado: "+ " \n Reparto a domicilio"
                showalert()
            } else if( !binding.reparto.isChecked && !binding.recogida.isChecked) {
                binding.ticket.setTextColor(Color.WHITE)
                toast = Toast.makeText(this, "No ha marcado ningúna opción de recogida", Toast.LENGTH_SHORT)
                toast?.show()

                }

            if(binding.recogida.isChecked){
                binding.ticket.setTextColor(Color.BLACK)
                binding.ticket.text=
                        ticketingredientes + "\n Ha seleccionado:"+"\n Recogida en tienda"

                showalert()

                }else if( !binding.reparto.isChecked && !binding.recogida.isChecked) {
                binding.ticket.setTextColor(Color.WHITE)
                    toast =  Toast.makeText(this, "No ha marcado ningúna opción de recogida", Toast.LENGTH_SHORT)

                toast?.show()
            }







            binding.limpiar.setOnClickListener() {
                binding.champiOnes.isChecked = false
                binding.atun.isChecked = false
                binding.aceitunas.isChecked = false
                binding.extra.isChecked = false
                binding.pepino.isChecked = false
                binding.piA.isChecked = false
                binding.reparto.isChecked= false
                binding.recogida.isChecked= false

                binding.ticket.text = ""
                selectedIngredients.clear()
                toast?.cancel()

            }









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

         fun showalert(){


             val alert = AlertDialog.Builder(this)

             alert.setTitle("Confirmación Pedido")
             alert.setMessage("¿Desea validar el pedido?")


             alert.setPositiveButton("Si"){
                     dialog, which->
                 var toast = Toast.makeText(this, "Pedido validado", Toast.LENGTH_SHORT)
                 toast.show()

                 val ticketactivity2 =  binding.ticket.text;

                 val intent = Intent(this, MainActivity3::class.java);
                 intent.putExtra("Ticket", ticketactivity2)
                 startActivity(intent)



                     dialog.dismiss()
                 }

               alert.setNegativeButton("No"){
                   dialog, which->
                   var toast = Toast.makeText(this, "Pedido cancelado", Toast.LENGTH_SHORT)
                   toast.show()
                   dialog.dismiss()
               }





             alert.create()
             alert.show()


         }
    }







