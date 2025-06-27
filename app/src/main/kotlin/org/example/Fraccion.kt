package org.example

class Fraccion(numeradorInicial: Int, denominadorInicial: Int) {
    private var _numerador = numeradorInicial
    private var _denominador = denominadorInicial

    var numerador: Int
        get() = _numerador
        set(value) {
            _numerador = value
            simplificar()
        }

    var denominador: Int
        get() = _denominador
        set(value) {
            if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
            _denominador = value
            normalizarSigno()
            simplificar()
        }

    init {
        if (_denominador == 0) {
            throw IllegalArgumentException("El denominador no puede ser cero")
        }
        normalizarSigno()
        simplificar()
    }

    private fun mcd(a: Int, b: Int): Int {
        var num1 = kotlin.math.abs(a)
        var num2 = kotlin.math.abs(b)
        while (num2 != 0) {
            val temp = num2
            num2 = num1 % num2
            num1 = temp
        }
        return num1
    }

    private fun simplificar() {
        if (_numerador != 0) {
            val divisor = mcd(_numerador, _denominador)
            _numerador /= divisor
            _denominador /= divisor
        }
    }

    private fun normalizarSigno() {
        if (_denominador < 0) {
            _numerador = -_numerador
            _denominador = -_denominador
        }
    }

    operator fun plus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.denominador + this.denominador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun minus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.denominador - this.denominador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    fun esValida(): Boolean = denominador != 0

    fun toDecimal(): Double = numerador.toDouble() / denominador.toDouble()

    override fun toString(): String =
        if (denominador == 1) numerador.toString() else "$numerador/$denominador"

    fun mostrar() = println(this)

    fun mostrarConDecimal() = println("$this = ${toDecimal()}")
}