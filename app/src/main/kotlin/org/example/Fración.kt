package org.example

class Fraccion(numeradorInicial: Int, denominadorInicial: Int) {
    
    var numerador: Int = 0
        get() = field
        set(value) {
            field = value
        }
    
    var denominador: Int = 1
        get() = field
        set(value) {
            if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
            field = value
        }
    
    // CORRECCIÓN 1: Inicializar las propiedades en el constructor
    init {
        // Validar denominador antes de asignar
        if (denominadorInicial == 0) {
            throw IllegalArgumentException("El denominador no puede ser cero")
        }
        
        // Asignar valores iniciales
        this.numerador = numeradorInicial
        this.denominador = denominadorInicial
    }
    
    // CORRECCIÓN 2: Implementar método toString()
    override fun toString(): String {
        return "$numerador/$denominador"
    }
    
    // CORRECCIÓN 3: Implementar método mostrar()
    fun mostrar() {
        println(this.toString())
    }
}