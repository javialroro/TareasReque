package com.example.tarea01

class Producto(
    var id: String,
    var Nombre: String,
    var cantVendidos: Int,
    var precioCosto: Int,
    var precioVenta: Int,
    var cantidad: Int
) {
    fun imprimirDetalles(): String {
        return "Nombre: $Nombre\nID: $id\nCantidad vendidos: $cantVendidos\nPrecio costo: $precioCosto\nPrecio venta: $precioVenta\nCantidad: $cantidad"
    }

    fun modificarDatos(nuevoPrecioCosto: Int, nuevoPrecioVenta: Int, nuevaCantidad: Int) {
        this.precioCosto = nuevoPrecioCosto
        this.precioVenta = nuevoPrecioVenta
        this.cantidad = nuevaCantidad
    }
    // Este es el constructor primario de la clase Producto
    // Los parámetros se declaran directamente en la declaración de la clase
    // No necesitas definir un constructor explícito
}
