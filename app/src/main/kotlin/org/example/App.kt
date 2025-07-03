package org.example

fun main() {
    println("=== PRUEBAS BÁSICAS (Etapa 1) ===")
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

    println("\n=== PRUEBAS DE OPERADORES SUMA Y RESTA (Etapa 2) ===")

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

    val suma2 = fraccion3 + fraccion1
    println("${fraccion3} + ${fraccion1} = ${suma2}")

    println("\n--- Operaciones de resta ---")
    val resta1 = fraccion3 - fraccion1
    println("${fraccion3} - ${fraccion1} = ${resta1}")

    val resta2 = fraccion1 - fraccion2
    println("${fraccion1} - ${fraccion2} = ${resta2}")

    val resta3 = fraccion2 - fraccion1
    println("${fraccion2} - ${fraccion1} = ${resta3}")

    println("\n--- Operaciones con fracciones negativas ---")
    val suma3 = fraccion1 + fraccion4
    println("${fraccion1} + ${fraccion4} = ${suma3}")

    val resta4 = fraccion1 - fraccion4
    println("${fraccion1} - ${fraccion4} = ${resta4}")

    println("\n=== PRUEBAS DE SIMPLIFICACIÓN (Etapa 2) ===")
    val fraccionCompleja1 = Fraccion(6, 8)
    val fraccionCompleja2 = Fraccion(10, 15)

    println("Fracciones que se simplifican automáticamente:")
    println("Fracción(6, 8) = ${fraccionCompleja1}")
    println("Fracción(10, 15) = ${fraccionCompleja2}")

    val sumaCompleja = fraccionCompleja1 + fraccionCompleja2
    println("${fraccionCompleja1} + ${fraccionCompleja2} = ${sumaCompleja}")

    println("\n=== OPERACIONES ENCADENADAS (Etapa 2) ===")
    val fEnc1 = Fraccion(1, 4)
    val fEnc2 = Fraccion(1, 4)
    val fEnc3 = Fraccion(1, 2)

    val resultadoEnc = fEnc1 + fEnc2 + fEnc3
    println("${fEnc1} + ${fEnc2} + ${fEnc3} = ${resultadoEnc}")

    println("\n=== MODIFICACIÓN DE PROPIEDADES (Etapa 1) ===")
    val fraccionModificable = Fraccion(1, 2)
    println("Fracción inicial: ${fraccionModificable}")

    fraccionModificable.numerador = 4
    println("Después de cambiar numerador a 4: ${fraccionModificable}")

    fraccionModificable.denominador = 6
    println("Después de cambiar denominador a 6: ${fraccionModificable}")

    println("\n=== MULTIPLICACIÓN Y DIVISIÓN (Etapa 3) ===")

    val m1 = Fraccion(2, 3)
    val m2 = Fraccion(3, 4)

    val producto = m1 * m2
    println("$m1 * $m2 = $producto")

    val cociente = m1 / m2
    println("$m1 / $m2 = $cociente")
}