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
    fun consultarProductos(view: View) {
        // Obtener el ID del producto a eliminar

        val id = findViewById<TextInputEditText>(R.id.id).text.toString()

        // Buscar el producto en la base de datos
        val productos = ProductosSingleton.productos

        // Si el producto existe, eliminarlo
        if (productos.isNotEmpty()) {

            var text: String = ""
            for (producto in productos) {
                text += producto.imprimirDetalles() + "\n\n"
            }
            findViewById<TextView>(R.id.eliminadoText).text = text
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Success")
            builder.setMessage("Producto consultado correctamente")
            builder.setPositiveButton("OK", null)
            builder.show()

        } else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
            builder.setMessage("No existen productos")
            builder.setPositiveButton("OK", null)
            builder.show()
        }
    }

    fun consultarProductoPorPrecio(view: View) {
        // Obtener el ID del producto a eliminar

        val precioVenta = findViewById<TextInputEditText>(R.id.id).text.toString().toIntOrNull()

        if (precioVenta != null) {
            // Buscar los productos en la base de datos que coincidan con el precio de venta
            val productos = ProductosSingleton.productos.filter { it.precioVenta == precioVenta }

            // Si el producto existe, eliminarlo
            if (productos.isNotEmpty()) {
                var text: String = ""
                for (producto in productos) {
                    text += producto.imprimirDetalles() + "\n\n"
                }
                findViewById<TextView>(R.id.eliminadoText).text = text
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Success")
                builder.setMessage("Productos consultados correctamente")
                builder.setPositiveButton("OK", null)
                builder.show()
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("No existen productos con el precio indicado")
                builder.setPositiveButton("OK", null)
                builder.show()
            }
        } else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
            builder.setMessage("Indique el precio que desea consultar")
            builder.setPositiveButton("OK", null)
            builder.show()
        }
    }

    fun consultarProductoPorCantidad(view: View) {
        // Obtener el ID del producto a eliminar

        val Cantidad = findViewById<TextInputEditText>(R.id.id).text.toString().toIntOrNull()

        if (Cantidad != null) {
            // Buscar los productos en la base de datos que coincidan con el precio de venta
            val productos = ProductosSingleton.productos.filter { it.cantidad == Cantidad }

            // Si el producto existe, eliminarlo
            if (productos.isNotEmpty()) {
                var text: String = ""
                for (producto in productos) {
                    text += producto.imprimirDetalles() + "\n\n"
                }
                findViewById<TextView>(R.id.eliminadoText).text = text
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Success")
                builder.setMessage("Productos consultados correctamente")
                builder.setPositiveButton("OK", null)
                builder.show()
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("No existen productos con la cantidad indicada")
                builder.setPositiveButton("OK", null)
                builder.show()
            }
        } else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
            builder.setMessage("Indique la cantidad que desea consultar")
            builder.setPositiveButton("OK", null)
            builder.show()
        }
    }

    fun consultarProductoPorCantidadVendidos(view: View) {
        // Obtener el ID del producto a eliminar

        val CantVendidos = findViewById<TextInputEditText>(R.id.id).text.toString().toIntOrNull()

        if (CantVendidos != null) {
            // Buscar los productos en la base de datos que coincidan con el precio de venta
            val productos = ProductosSingleton.productos.filter { it.cantVendidos == CantVendidos }

            // Si el producto existe, eliminarlo
            if (productos.isNotEmpty()) {
                var text: String = ""
                for (producto in productos) {
                    text += producto.imprimirDetalles() + "\n\n"
                }
                findViewById<TextView>(R.id.eliminadoText).text = text
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Success")
                builder.setMessage("Productos consultados correctamente")
                builder.setPositiveButton("OK", null)
                builder.show()
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("No existen productos con la cantidad indicada")
                builder.setPositiveButton("OK", null)
                builder.show()
            }
        } else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
            builder.setMessage("Indique la cantidad que desea consultar")
            builder.setPositiveButton("OK", null)
            builder.show()
        }
    }
}