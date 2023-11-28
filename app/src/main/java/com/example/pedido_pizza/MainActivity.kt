package com.example.pedido_pizza

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.URLUtil
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
                selectedIngredients.add(getString(R.string.champiñones))


            } else {
                selectedIngredients.remove(getString(R.string.champiñones))
            }

            if (binding.atun.isChecked) {
                selectedIngredients.add(getString(R.string.atun))

            } else {
                selectedIngredients.remove(getString(R.string.atun))
            }

            if (binding.aceitunas.isChecked) {
                selectedIngredients.add(getString(R.string.aceitunas))


            } else {
                selectedIngredients.remove(getString(R.string.aceitunas))
            }
            if (binding.piA.isChecked) {
                selectedIngredients.add(getString(R.string.piña))

            } else {
                selectedIngredients.remove(getString(R.string.piña))
            }

            if (binding.extra.isChecked) {
                selectedIngredients.add(getString(R.string.extra))

            } else {
                selectedIngredients.remove(getString(R.string.extra))
            }

            if (binding.pepino.isChecked) {
                selectedIngredients.add(getString(R.string.pepino))

            } else {
                selectedIngredients.remove(getString(R.string.pepino))
            }




            if (selectedIngredients.isNotEmpty()) {
                val ingredientes = getString(R.string.Ingredientes)
                println(ingredientes)
                ticketingredientes =
                    "Ticket :\n $ingredientes : ${selectedIngredients.joinToString(", ")}"
                binding.ticket.text = ticketingredientes


            } else {
                binding.ticket.text = "Ningún ingrediente seleccionado."
                // toast= Toast.makeText(this, "No ha marcado ningún ingrediente", Toast.LENGTH_SHORT)
            }


            if (binding.reparto.isChecked) {

                val seleccion = getString(R.string.seleccion)
                val domicilio = getString(R.string.domicilio)

                binding.ticket.text =
                    ticketingredientes + " \n $seleccion " + " \n $domicilio"
                showalert()
            } else if (!binding.reparto.isChecked && !binding.recogida.isChecked) {
                binding.ticket.setTextColor(Color.WHITE)
                toast = Toast.makeText(
                    this,
                    "No ha marcado ningúna opción de recogida",
                    Toast.LENGTH_SHORT
                )
                toast?.show()

            }

            if (binding.recogida.isChecked) {
                val seleccion = getString(R.string.seleccion)
                val tienda = getString(R.string.tienda)
                binding.ticket.setTextColor(Color.BLACK)
                binding.ticket.text =
                    ticketingredientes + "\n $seleccion" + "\n $tienda"

                showalert()

            } else if (!binding.reparto.isChecked && !binding.recogida.isChecked) {
                binding.ticket.setTextColor(Color.WHITE)
                toast = Toast.makeText(
                    this,
                    "No ha marcado ningúna opción de recogida",
                    Toast.LENGTH_SHORT
                )

                toast?.show()
            }
        }


        binding.limpiar.setOnClickListener() {
            binding.champiOnes.isChecked = false
            binding.atun.isChecked = false
            binding.aceitunas.isChecked = false
            binding.extra.isChecked = false
            binding.pepino.isChecked = false
            binding.piA.isChecked = false
            binding.reparto.isChecked = false
            binding.recogida.isChecked = false

            binding.ticket.text = ""
            selectedIngredients.clear()
            toast?.cancel()

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

             alert.setTitle(R.string.Confirmacion)
             alert.setMessage(R.string.Desea_validar)


             alert.setPositiveButton(R.string.si){
                     dialog, which->
                 var toast = Toast.makeText(this, R.string.Validado, Toast.LENGTH_SHORT)
                 toast.show()

                 val ticketactivity2 =  binding.ticket.text;

                 val intent = Intent(this, MainActivity3::class.java);
                 intent.putExtra("Ticket", ticketactivity2)
                 startActivity(intent)



                     dialog.dismiss()
                 }

               alert.setNegativeButton(R.string.no){
                   dialog, which->
                   var toast = Toast.makeText(this, R.string.pedido_cancelado, Toast.LENGTH_SHORT)
                   toast.show()
                   dialog.dismiss()

                   val intent = Intent(this, MainActivityportada::class.java);

                   startActivity(intent)
               }





             alert.create()
             alert.show()


         }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menus, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId==R.id.share_action) {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Pizzeria Pedido")
                type = "Text/plain"
            }
            try {
                startActivity(sendIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "No se puede", Toast.LENGTH_SHORT).show()
            }
        }

        if (item.itemId == R.id.Inicio_app) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }

        if (item.itemId == R.id.acerca) {
            Toast.makeText(this, "Realizado por Belén Bastos", Toast.LENGTH_SHORT).show()

        }

        if (item.itemId == R.id.Enlace_Pizzeria) {
            openWebPage(this, "https://en.wikipedia.org/wiki/Satellite_of_Love")


        }





        return true
    }

    fun openWebPage(context: Context, url: String?) {
        try {
            if (!URLUtil.isValidUrl(url)) {
                Toast.makeText(context, " This is not a valid link", Toast.LENGTH_LONG).show()
            } else {
                //OPCION1
                // val intent = Intent (Intent.ACTION_VIEW, Uri.parse(url));

                //OPCION2
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)

                context.startActivity(intent)

            }
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(
                context,
                " You don't have any browser to open web page",
                Toast.LENGTH_LONG
            ).show()
        }
    }
    }







