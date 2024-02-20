package com.example.tarea01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

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
}