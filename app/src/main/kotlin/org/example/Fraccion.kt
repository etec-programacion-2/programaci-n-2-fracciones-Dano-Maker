package org.example

<<<<<<< HEAD
=======
// ====================================
// === Etapa 1: Definición de la Clase
// ====================================
class Fraccion(
    numerador: Int,
    denominador: Int
) {
    private var _numerador: Int = numerador
    private var _denominador: Int = denominador

    init {
        if (denominador == 0) throw IllegalArgumentException("El denominador no puede ser cero")
        // Normalizar signo
        if (_denominador < 0) {
            _numerador = -_numerador
            _denominador = -_denominador
        }
        simplificar()
    }
>>>>>>> 4ea027c8aab949c377cacd4bbfb5ab03e2e1aa38


<<<<<<< HEAD
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

=======
    var denominador: Int
        get() = _denominador
        set(value) {
            if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
            _denominador = value
            if (_denominador < 0) {
                _numerador = -_numerador
                _denominador = -_denominador
            }
            simplificar()
        }

    fun mostrar() {
        println(this.toString())
    }

    override fun toString(): String {
        return if (_denominador == 1) {
            _numerador.toString()
        } else {
            "$_numerador/$_denominador"
>>>>>>> 4ea027c8aab949c377cacd4bbfb5ab03e2e1aa38
        }



        val mcd = mcd(kotlin.math.abs(numerador), kotlin.math.abs(denominador))

        numerador /= mcd

        denominador /= mcd

    }

<<<<<<< HEAD


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

=======
    fun obtenerValor(): String {
        return toString()
    }

    fun mostrarFraccion(): String {
        return "$_numerador / $_denominador es una fracción"
    }

    // ============================================
    // === Etapa 2: Suma y Resta de Fracciones
    // ============================================

    operator fun plus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this._numerador * otra._denominador + this._denominador * otra._numerador
        val nuevoDenominador = this._denominador * otra._denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun minus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this._numerador * otra._denominador - this._denominador * otra._numerador
        val nuevoDenominador = this._denominador * otra._denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    // ================================================
    // === Etapa 3: Multiplicación y División
    // ================================================

    operator fun times(otra: Fraccion): Fraccion {
        val nuevoNumerador = this._numerador * otra._numerador
        val nuevoDenominador = this._denominador * otra._denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun div(otra: Fraccion): Fraccion {
        if (otra._numerador == 0) {
            throw IllegalArgumentException("No se puede dividir por una fracción con numerador cero")
        }
        val nuevoNumerador = this._numerador * otra._denominador
        val nuevoDenominador = this._denominador * otra._numerador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    // ===================================================
    // === Etapa 2 y 3: Método privado para simplificar
    // ===================================================
    private fun simplificar() {
        val mcd = calcularMCD(kotlin.math.abs(_numerador), kotlin.math.abs(_denominador))
        if (mcd > 1) {
            _numerador /= mcd
            _denominador /= mcd
        }
    }

    private fun calcularMCD(a: Int, b: Int): Int {
        return if (b == 0) a else calcularMCD(b, a % b)
    }

    // ======================================
    // === Etapa 4: Métodos de Utilidad
    // ======================================

    fun aDecimal(): Double = _numerador.toDouble() / _denominador.toDouble()

    fun esMayor(otra: Fraccion): Boolean {
        return this.compareTo(otra) > 0
    }

    fun esMenor(otra: Fraccion): Boolean {
        return this.compareTo(otra) < 0
    }

    // ======================================
    // === Etapa 4: Comparaciones
    // ======================================

    operator fun compareTo(otra: Fraccion): Int {
        val thisDecimal = this.aDecimal()
        val otherDecimal = otra.aDecimal()
        return when {
            thisDecimal < otherDecimal -> -1
            thisDecimal > otherDecimal -> 1
            else -> 0
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fraccion) return false
        return _numerador == other._numerador && _denominador == other._denominador
    }

    override fun hashCode(): Int {
        return 31 * _numerador + _denominador
    }

    // ======================================
    // === Etapa 4: Conversión desde Decimal
    // ======================================

    companion object {
        fun desdeDecimal(decimal: Double): Fraccion {
            val denominador = 10000
            val numerador = (decimal * denominador).toInt()
            return Fraccion(numerador, denominador)
        }
    }
>>>>>>> 4ea027c8aab949c377cacd4bbfb5ab03e2e1aa38
}