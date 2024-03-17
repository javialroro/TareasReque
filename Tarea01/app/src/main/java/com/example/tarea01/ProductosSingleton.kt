package com.example.tarea01

object ProductosSingleton {
    val productos: MutableList<Producto> = mutableListOf()

    fun agregarProducto(producto: Producto) {
        productos.add(producto)
    }

}