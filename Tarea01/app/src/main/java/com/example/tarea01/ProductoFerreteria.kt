package com.example.tarea01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText

class ProductoFerreteria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_ferreteria)
    }

    fun consultarProductosPorFerreteria1(view: View) {
        // Obtener el ID del producto a eliminar

        val productos = ProductosSingleton.productos.filter { it.ferreteria.equals("Ferretería 1") }
        // Buscar el producto en la base de datos

        // Si el producto existe, eliminarlo
        if (productos.isNotEmpty()) {

            var text: String = ""
            for (producto in productos) {
                text += producto.imprimirDetalles() + "\n\n"
            }
            findViewById<TextView>(R.id.prodPorFerretxt).text = text
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

    fun consultarProductosPorFerreteria2(view: View) {
        // Obtener el ID del producto a eliminar

        val productos = ProductosSingleton.productos.filter { it.ferreteria.equals("Ferretería 2") }
        // Buscar el producto en la base de datos

        // Si el producto existe, eliminarlo
        if (productos.isNotEmpty()) {

            var text: String = ""
            for (producto in productos) {
                text += producto.imprimirDetalles() + "\n\n"
            }
            findViewById<TextView>(R.id.prodPorFerretxt).text = text
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

    fun consultarProductosPorFerreteria3(view: View) {
        // Obtener el ID del producto a eliminar

        val productos = ProductosSingleton.productos.filter { it.ferreteria.equals("Ferretería 3") }
        // Buscar el producto en la base de datos

        // Si el producto existe, eliminarlo
        if (productos.isNotEmpty()) {

            var text: String = ""
            for (producto in productos) {
                text += producto.imprimirDetalles() + "\n\n"
            }
            findViewById<TextView>(R.id.prodPorFerretxt).text = text
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
}