package com.example.tarea01

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tarea01.ui.theme.Tarea01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

    }

    fun botonAgregar(view: View) {
        setContentView(R.layout.agregar)
    }

    fun botonConsultar(view: View) {
        setContentView(R.layout.consultar)
    }

    fun botonEliminar(view: View) {
        setContentView(R.layout.eliminar)
    }

    fun botonModificar(view: View) {
        setContentView(R.layout.modificar)
    }
}

