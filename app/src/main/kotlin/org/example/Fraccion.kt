package org.example



import java.util.Scanner

import java.util.InputMismatchException

import kotlin.math.roundToInt



data class Fraccion(var numerador: Int, var denominador: Int) {



    init {

        require(denominador != 0) { "El denominador no puede ser cero" }



        // Normaliza el signo: denominador siempre positivo

        if (denominador < 0) {

            numerador *= -1

            denominador *= -1

        }



        simplificar()

    }



    fun mostrar() {

        println(this)

    }



    fun aDecimal(): Double = numerador.toDouble() / denominador



    operator fun plus(other: Fraccion): Fraccion {

        val num = this.numerador * other.denominador + other.numerador * this.denominador

        val den = this.denominador * other.denominador

        return Fraccion(num, den)

    }



    operator fun minus(other: Fraccion): Fraccion {

        val num = this.numerador * other.denominador - other.numerador * this.denominador

        val den = this.denominador * other.denominador

        return Fraccion(num, den)

    }



    operator fun times(other: Fraccion): Fraccion {

        return Fraccion(this.numerador * other.numerador, this.denominador * other.denominador)

    }



    operator fun div(other: Fraccion): Fraccion {

        require(other.numerador != 0) { "No se puede dividir por una fracción con numerador 0" }

        return Fraccion(this.numerador * other.denominador, this.denominador * other.numerador)

    }



    fun esMayor(other: Fraccion) = this.aDecimal() > other.aDecimal()

    fun esMenor(other: Fraccion) = this.aDecimal() < other.aDecimal()



    companion object {

        fun desdeDecimal(decimalInput: Double): Fraccion {

            val precision = 1000

            val numerador = (decimalInput * precision).roundToInt()

            return Fraccion(numerador, precision)

        }

    }



    private fun simplificar() {

        if (numerador == 0) {

            denominador = 1

            return

        }



        val mcd = mcd(kotlin.math.abs(numerador), kotlin.math.abs(denominador))

        numerador /= mcd

        denominador /= mcd

    }



    private fun mcd(a: Int, b: Int): Int {

        return if (b == 0) a else mcd(b, a % b)

    }



    override fun toString(): String = "$numerador/$denominador"

}



// === FUNCIONES DEL MENÚ ===



fun mostrarMenu() {

    println("\n=== CALCULADORA DE FRACCIONES ===")

    println("1. Sumar fracciones")

    println("2. Restar fracciones")

    println("3. Multiplicar fracciones")

    println("4. Dividir fracciones")

    println("5. Comparar fracciones")

    println("6. Convertir fracción a decimal")

    println("7. Crear fracción desde decimal")

    println("8. Ejemplos predefinidos")

    println("0. Salir")

    print("Ingrese su opción: ")

}



fun leerFraccion(scanner: Scanner, mensaje: String): Fraccion? {

    return try {

        println(mensaje)

        print("Numerador: ")

        val numInput = scanner.nextLine()

        val numerador = numInput.toIntOrNull() ?: throw InputMismatchException()



        print("Denominador: ")

        val denInput = scanner.nextLine()

        val denominador = denInput.toIntOrNull() ?: throw InputMismatchException()



        Fraccion(numerador, denominador)

    } catch (e: InputMismatchException) {

        println("Error: Ingrese números enteros válidos.")

        null

    } catch (e: IllegalArgumentException) {

        println("Error: ${e.message}")

        null

    }

}



fun realizarSuma(scanner: Scanner) {

    val f1 = leerFraccion(scanner, "Ingrese la primera fracción:")

    val f2 = leerFraccion(scanner, "Ingrese la segunda fracción:")

    if (f1 != null && f2 != null) println("Resultado: $f1 + $f2 = ${f1 + f2}")

}



fun realizarResta(scanner: Scanner) {

    val f1 = leerFraccion(scanner, "Ingrese la primera fracción:")

    val f2 = leerFraccion(scanner, "Ingrese la segunda fracción:")

    if (f1 != null && f2 != null) println("Resultado: $f1 - $f2 = ${f1 - f2}")

}



fun realizarMultiplicacion(scanner: Scanner) {

    val f1 = leerFraccion(scanner, "Ingrese la primera fracción:")

    val f2 = leerFraccion(scanner, "Ingrese la segunda fracción:")

    if (f1 != null && f2 != null) println("Resultado: $f1 * $f2 = ${f1 * f2}")

}



fun realizarDivision(scanner: Scanner) {

    val f1 = leerFraccion(scanner, "Ingrese la primera fracción:")

    val f2 = leerFraccion(scanner, "Ingrese la segunda fracción:")

    if (f1 != null && f2 != null) {

        try {

            println("Resultado: $f1 / $f2 = ${f1 / f2}")

        } catch (e: IllegalArgumentException) {

            println("Error: ${e.message}")

        }

    }

}



fun realizarComparacion(scanner: Scanner) {

    val f1 = leerFraccion(scanner, "Ingrese la primera fracción:")

    val f2 = leerFraccion(scanner, "Ingrese la segunda fracción:")

    if (f1 != null && f2 != null) {

        when {

            f1.esMayor(f2) -> println("$f1 es mayor que $f2")

            f1.esMenor(f2) -> println("$f1 es menor que $f2")

            else -> println("$f1 es igual a $f2")

        }

    }

}



fun convertirADecimal(scanner: Scanner) {

    val fraccion = leerFraccion(scanner, "Ingrese la fracción a convertir:")

    if (fraccion != null) println("$fraccion en decimal = ${fraccion.aDecimal()}")

}



fun crearDesdeDecimal(scanner: Scanner) {

    try {

        print("Ingrese un número decimal (puede usar ',' o '.'): ")

        val entrada = scanner.nextLine().replace(",", ".")

        val decimal = entrada.toDoubleOrNull()



        if (decimal != null) {

            val fraccion = Fraccion.desdeDecimal(decimal)

            println("$decimal como fracción = $fraccion")

        } else {

            println("Error: Ingrese un número decimal válido.")

        }

    } catch (e: Exception) {

        println("Error inesperado: ${e.message}")

    }

}



fun mostrarEjemplos() {

    val f1 = Fraccion(1, 2)

    val f2 = Fraccion(1, 3)

    println("Fracción 1: $f1")

    println("Fracción 2: $f2")

    println("Suma: ${f1 + f2}")

    println("Resta: ${f1 - f2}")

    println("Multiplicación: ${f1 * f2}")

    println("División: ${f1 / f2}")

    println("Comparación: ¿$f1 > $f2? ${f1.esMayor(f2)}")

    println("Decimal de $f1: ${f1.aDecimal()}")



    val decimal = 0.75

    val fDecimal = Fraccion.desdeDecimal(decimal)

    println("\nDesde decimal: $decimal = $fDecimal")

}