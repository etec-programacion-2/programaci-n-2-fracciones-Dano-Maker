package org.example

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var opcion: Int

    do {
        try {
            mostrarMenu()
            val input = scanner.nextLine()
            opcion = input.toIntOrNull() ?: -1

            when (opcion) {
                1 -> realizarSuma(scanner)
                2 -> realizarResta(scanner)
                3 -> realizarMultiplicacion(scanner)
                4 -> realizarDivision(scanner)
                5 -> realizarComparacion(scanner)
                6 -> convertirADecimal(scanner)
                7 -> crearDesdeDecimal(scanner)
                8 -> mostrarEjemplos()
                0 -> println("¡Hasta luego!")
                else -> println("Opción inválida. Ingrese un número del 0 al 8.")
            }

            if (opcion != 0) {
                println("\nPresione Enter para continuar...")
                scanner.nextLine()
            }
        } catch (e: Exception) {
            println("Error inesperado: ${e.message}")
            opcion = -1
        }
    } while (opcion != 0)

    scanner.close()
}