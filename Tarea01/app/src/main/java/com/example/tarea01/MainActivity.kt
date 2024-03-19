package com.example.tarea01

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        // Configurar el icono de hamburguesa
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        drawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {}
            override fun onDrawerOpened(drawerView: View) {}
            override fun onDrawerClosed(drawerView: View) {}
            override fun onDrawerStateChanged(newState: Int) {}
        })

        // Manejar la apertura y cierre del menú hamburguesa
        navView.setNavigationItemSelectedListener { menuItem ->
            // Acciones al hacer clic en un elemento del menú
            when (menuItem.itemId) {
                R.id.nav_CRUD -> {
                    val intent = Intent()
                    intent.setClass(this@MainActivity,MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_ferreteriasCerca -> {
                    // Acción para el elemento "Gallery"
                    val intent = Intent()
                    intent.setClass(this@MainActivity,FerreteriasCerca::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_ProductoFerreteria -> {
                    // Acción para el elemento "Gallery"
                    val intent = Intent()
                    intent.setClass(this@MainActivity,ProductoFerreteria::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Abrir el DrawerLayout al hacer clic en el icono de hamburguesa o en el botón de retroceso
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun abrirAgregar(view: View){
        val intent = Intent()
        intent.setClass(this@MainActivity,Agregar::class.java)
        startActivity(intent)
    }

    fun abrirConsultar(view: View){
        val intent = Intent()
        intent.setClass(this@MainActivity,Consultar::class.java)
        startActivity(intent)
    }


    fun abrirEliminar(view: View){
        val intent = Intent()
        intent.setClass(this@MainActivity,Eliminar::class.java)
        startActivity(intent)
    }
    fun abrirModificar(view: View){
        val intent = Intent()
        intent.setClass(this@MainActivity,Modificar::class.java)
        startActivity(intent)
    }

    fun verProductos(view: View) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Productos")

        val mensaje = StringBuilder()
        mensaje.append("Productos en la base de datos: \n")
        for (producto in ProductosSingleton.productos) {
            mensaje.append(producto.imprimirDetalles())
        }

        builder.setMessage(mensaje.toString())
        builder.setPositiveButton("OK", null)
        builder.show()
    }


}

