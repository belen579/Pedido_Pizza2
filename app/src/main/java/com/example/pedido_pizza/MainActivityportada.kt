package com.example.pedido_pizza

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.URLUtil
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity


class MainActivityportada : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activityportada)


    }



    fun goToSecondActivity(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
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








