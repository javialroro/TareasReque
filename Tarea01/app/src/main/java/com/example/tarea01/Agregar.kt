package com.example.tarea01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText

class Agregar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_agregar)
        }
        catch (e: Exception) {
            // Log the exception for debugging purposes
            println(e)

            // Handle the exception gracefully, for example:
            // Show an error message to the user
            // Toast.makeText(this, "Error occurred", Toast.LENGTH_SHORT).show()

            // Finish the activity to prevent further issues
            finish()
        }
    }

    fun agregarProducto(view: View) {
        // Obtener los valores de la interfaz de usuario
        val id = findViewById<TextInputEditText>(R.id.id).text.toString()
        val nombre = findViewById<TextInputEditText>(R.id.nombre).text.toString()
        val precioCostos = findViewById<TextInputEditText>(R.id.precioCosto).text.toString().toIntOrNull()
        val precioVenta = findViewById<TextInputEditText>(R.id.precioVenta).text.toString().toIntOrNull()
        val cantidadVendidos = findViewById<TextInputEditText>(R.id.cantidadV).text.toString().toIntOrNull()
        val cantidad = findViewById<TextInputEditText>(R.id.cantidad).text.toString().toIntOrNull()

        try {
            // Verificar que los valores no sean nulos
            if (precioCostos != null && precioVenta != null && cantidadVendidos != null && cantidad != null) {
                // Crear un nuevo producto
                val producto = Producto(id, nombre, precioCostos, precioVenta, cantidadVendidos, cantidad)

                // Agregar el producto a la base de datos (en este caso, a la MainActivity)
                ProductosSingleton.agregarProducto(producto)
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Success")
                builder.setMessage("Producto agregado correctamente")
                builder.setPositiveButton("OK", null)
                builder.show()
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("Ingrese todos los campos")
                builder.setPositiveButton("OK", null)
                builder.show()
            }
        } catch (e: NumberFormatException) {
            // Manejar el caso en que la conversión de texto a número falle
            // Por ejemplo, mostrar un mensaje de error al usuario
        }
    }

}