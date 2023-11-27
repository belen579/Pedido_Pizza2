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
        if (item.itemId == R.id.Inicio_app) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }
        if (item.itemId == R.id.acerca) {
            Toast.makeText(this, "Realizado por Belen Bastos", Toast.LENGTH_SHORT).show()
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

/*

        showMessage(menuItem.title.toString())

        //DEPRICATED
        // Verify the original intent will resolve to at least one activity
        //                if (sendIntent.resolveActivity(packageManager) != null) {
        //              startActivity(chooser);
        //                }
        //                else showMessage("No se puede")

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            type = "text/plain"
        }

        /*
        https://developer.android.com/training/sharing/send?hl=es-419
        * */

        // Always use string resources for UI text.
        // This says something like "Share this video via"
//                val title:String = resources.getString(R.string.chooser_title)

        // Create intent to show the chooser dialog
        /* val chooser= Intent.createChooser(sendIntent, title);
         *
         * EXPLICACIÓN de SU NO USO
         *
         * El agente de resolución de intent de Android se usa mejor cuando se envían datos a otra app como parte de un flujo de tareas bien definido.

Para usar el agente de resolución de intent de Android, crea un intent y agrega servicios adicionales como si llamaras a Android Sharesheet. Sin embargo, no debes llamar a Intent.createChooser().

Si hay varias aplicaciones instaladas con filtros que coinciden con ACTION_SEND y el tipo de MIME, el sistema mostrará un diálogo de desambiguación, denominado agente de resolución de intent, que permite al usuario elegir un destino donde compartir. Si se encuentra una aplicación, se ejecutará.
         * */

        try {
            // startActivity(chooser)
            startActivity(sendIntent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "No se puede", Toast.LENGTH_SHORT)
                .show()
        }
        true
    }*/
