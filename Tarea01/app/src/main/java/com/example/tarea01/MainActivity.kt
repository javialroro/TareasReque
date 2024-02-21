package com.example.tarea01

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

