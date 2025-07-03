package org.example

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
        }
    }

    fun obtenerValor(): String {
        return toString()
    }

    fun mostrarFraccion(): String {
        return "$_numerador / $_denominador es una fracción"
    }


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
}