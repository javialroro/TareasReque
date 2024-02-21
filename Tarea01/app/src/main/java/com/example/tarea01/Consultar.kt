package com.example.tarea01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText

class Consultar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)
    }
    fun consultarProducto(view: View) {
        // Obtener el ID del producto a eliminar

        val id = findViewById<TextInputEditText>(R.id.id).text.toString()

        // Buscar el producto en la base de datos
        val producto = ProductosSingleton.productos.find { it.id == id }

        // Si el producto existe, eliminarlo
        if (producto != null) {

            findViewById<TextView>(R.id.eliminadoText).text = "El producto consultado fue: \n"+producto.imprimirDetalles()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Success")
            builder.setMessage("Producto consultado correctamente")
            builder.setPositiveButton("OK", null)
            builder.show()

        } else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
            builder.setMessage("No se encontró un producto con el ID especificado")
            builder.setPositiveButton("OK", null)
            builder.show()
        }
    }
}