
package org.example

fun main() {
    // Crear una instancia de Fracción
    val fraccion = Fraccion(3, 4)

    fraccion.mostrar()
    fraccion.numerador = 5
    fraccion.mostrar()
    fraccion.denominador = 2
    fraccion.mostrar()

    try {
        fraccion.denominador = 0
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
