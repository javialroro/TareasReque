package com.example.tarea01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText

class Modificar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar)
    }

    fun modificarProducto(view: View) {

        // Obtener el ID del producto a modificar
        val id = findViewById<TextInputEditText>(R.id.idProducto).text.toString()
        val nuevoPrecioCosto = findViewById<TextInputEditText>(R.id.precioCosto).text.toString().toIntOrNull()
        val nuevoPrecioVenta = findViewById<TextInputEditText>(R.id.precioVenta).text.toString().toIntOrNull()
        val nuevaCantidad = findViewById<TextInputEditText>(R.id.cantidad).text.toString().toIntOrNull()

        // Buscar el producto en la base de datos
        val producto = ProductosSingleton.productos.find { it.id == id }

        // Si el producto existe, eliminarlo
        if (producto != null) {
            if (nuevoPrecioCosto != null)
                producto.precioCosto = nuevoPrecioCosto
            if (nuevoPrecioVenta != null)
                producto.precioVenta = nuevoPrecioVenta
            if (nuevaCantidad != null)
                producto.cantidad = nuevaCantidad
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Success")
            builder.setMessage("Producto modificado correctamente")
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