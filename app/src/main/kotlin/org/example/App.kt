package org.example

fun main() {
    println("=== PRUEBAS BÁSICAS (código original) ===")
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

    println("\n=== PRUEBAS DE OPERADORES SUMA Y RESTA ===")

    val fraccion1 = Fraccion(1, 2)
    val fraccion2 = Fraccion(1, 3)
    val fraccion3 = Fraccion(3, 4)
    val fraccion4 = Fraccion(-1, 3)

    println("Fracciones creadas:")
    print("fraccion1: "); fraccion1.mostrar()
    print("fraccion2: "); fraccion2.mostrar()
    print("fraccion3: "); fraccion3.mostrar()
    print("fraccion4: "); fraccion4.mostrar()

    println("\n--- Operaciones de suma ---")
    val suma1 = fraccion1 + fraccion2
    println("${fraccion1} + ${fraccion2} = ${suma1}")
    suma1.mostrarConDecimal()

    val suma2 = fraccion3 + fraccion1
    println("${fraccion3} + ${fraccion1} = ${suma2}")
    suma2.mostrarConDecimal()

    println("\n--- Operaciones de resta ---")
    val resta1 = fraccion3 - fraccion1
    println("${fraccion3} - ${fraccion1} = ${resta1}")
    resta1.mostrarConDecimal()

    val resta2 = fraccion1 - fraccion2
    println("${fraccion1} - ${fraccion2} = ${resta2}")
    resta2.mostrarConDecimal()

    val resta3 = fraccion2 - fraccion1
    println("${fraccion2} - ${fraccion1} = ${resta3}")
    resta3.mostrarConDecimal()

    println("\n--- Operaciones con fracciones negativas ---")
    val suma3 = fraccion1 + fraccion4
    println("${fraccion1} + ${fraccion4} = ${suma3}")
    suma3.mostrarConDecimal()

    val resta4 = fraccion1 - fraccion4
    println("${fraccion1} - ${fraccion4} = ${resta4}")
    resta4.mostrarConDecimal()

    println("\n=== PRUEBAS DE SIMPLIFICACIÓN ===")
    val fraccionCompleja1 = Fraccion(6, 8)
    val fraccionCompleja2 = Fraccion(10, 15)

    println("Fracciones que se simplifican automáticamente:")
    println("Fracción(6, 8) = ${fraccionCompleja1}")
    println("Fracción(10, 15) = ${fraccionCompleja2}")

    val sumaCompleja = fraccionCompleja1 + fraccionCompleja2
    println("${fraccionCompleja1} + ${fraccionCompleja2} = ${sumaCompleja}")
    sumaCompleja.mostrarConDecimal()

    println("\n=== PRUEBAS DE VALIDACIÓN ===")
    try {
        val fraccionInvalida = Fraccion(1, 0)
    } catch (e: IllegalArgumentException) {
        println("Error al crear fracción con denominador 0: ${e.message}")
    }

    try {
        val f1 = Fraccion(1, 2)
        val f2 = Fraccion(1, 1)
        println("Intentando cambiar denominador a 0...")
        f2.denominador = 0
        val resultado = f1 + f2
    } catch (e: IllegalArgumentException) {
        println("Error capturado correctamente: ${e.message}")
    }

    println("\n=== OPERACIONES ENCADENADAS ===")
    val f1 = Fraccion(1, 4)
    val f2 = Fraccion(1, 4)
    val f3 = Fraccion(1, 2)

    val resultado = f1 + f2 + f3
    println("${f1} + ${f2} + ${f3} = ${resultado}")
    resultado.mostrarConDecimal()

    println("\n=== MODIFICACIÓN DE PROPIEDADES ===")
    val fraccionModificable = Fraccion(1, 2)
    println("Fracción inicial: ${fraccionModificable}")

    fraccionModificable.numerador = 4
    println("Después de cambiar numerador a 4: ${fraccionModificable}")

    fraccionModificable.denominador = 6
    println("Después de cambiar denominador a 6: ${fraccionModificable}")
}