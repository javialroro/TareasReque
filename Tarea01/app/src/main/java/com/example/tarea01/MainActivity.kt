package com.example.tarea01

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity

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

}

