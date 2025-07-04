package org.example

fun main() {
    // ====================================
    // === Etapa 1: Pruebas Básicas
    // ====================================
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

    // ================================================
    // === Etapa 2: Pruebas de Suma y Resta
    // ================================================
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
    println("Decimal: ${suma1.aDecimal()}")

    val suma2 = fraccion3 + fraccion1
    println("${fraccion3} + ${fraccion1} = ${suma2}")
    println("Decimal: ${suma2.aDecimal()}")

    println("\n--- Operaciones de resta ---")
    val resta1 = fraccion3 - fraccion1
    println("${fraccion3} - ${fraccion1} = ${resta1}")
    println("Decimal: ${resta1.aDecimal()}")

    val resta2 = fraccion1 - fraccion2
    println("${fraccion1} - ${fraccion2} = ${resta2}")
    println("Decimal: ${resta2.aDecimal()}")

    val resta3 = fraccion2 - fraccion1
    println("${fraccion2} - ${fraccion1} = ${resta3}")
    println("Decimal: ${resta3.aDecimal()}")

    println("\n--- Operaciones con fracciones negativas ---")
    val suma3 = fraccion1 + fraccion4
    println("${fraccion1} + ${fraccion4} = ${suma3}")
    println("Decimal: ${suma3.aDecimal()}")

    val resta4 = fraccion1 - fraccion4
    println("${fraccion1} - ${fraccion4} = ${resta4}")
    println("Decimal: ${resta4.aDecimal()}")

    // ================================================
    // === Etapa 2: Pruebas de Simplificación
    // ================================================
    println("\n=== PRUEBAS DE SIMPLIFICACIÓN (Etapa 2) ===")
    val fraccionCompleja1 = Fraccion(6, 8)
    val fraccionCompleja2 = Fraccion(10, 15)

    println("Fracciones que se simplifican automáticamente:")
    println("Fracción(6, 8) = ${fraccionCompleja1}")
    println("Fracción(10, 15) = ${fraccionCompleja2}")

    val sumaCompleja = fraccionCompleja1 + fraccionCompleja2
    println("${fraccionCompleja1} + ${fraccionCompleja2} = ${sumaCompleja}")
    println("Decimal: ${sumaCompleja.aDecimal()}")

    // ================================================
    // === Etapa 4: Validaciones (denominador = 0)
    // ================================================
    println("\n=== PRUEBAS DE VALIDACIÓN (Etapa 4) ===")
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

    // ================================================
    // === Etapa 2: Operaciones encadenadas
    // ================================================
    println("\n=== OPERACIONES ENCADENADAS (Etapa 2) ===")
    val fEnc1 = Fraccion(1, 4)
    val fEnc2 = Fraccion(1, 4)
    val fEnc3 = Fraccion(1, 2)

    val resultadoEnc = fEnc1 + fEnc2 + fEnc3
    println("${fEnc1} + ${fEnc2} + ${fEnc3} = ${resultadoEnc}")
    println("Decimal: ${resultadoEnc.aDecimal()}")

    // ================================================
    // === Etapa 1: Modificación de propiedades
    // ================================================
    println("\n=== MODIFICACIÓN DE PROPIEDADES (Etapa 1) ===")
    val fraccionModificable = Fraccion(1, 2)
    println("Fracción inicial: ${fraccionModificable}")

    fraccionModificable.numerador = 4
    println("Después de cambiar numerador a 4: ${fraccionModificable}")

    fraccionModificable.denominador = 6
    println("Después de cambiar denominador a 6: ${fraccionModificable}")

    // ================================================
    // === Etapa 3: Multiplicación y División
    // ================================================
    println("\n=== MULTIPLICACIÓN Y DIVISIÓN (Etapa 3) ===")

    val m1 = Fraccion(2, 3)
    val m2 = Fraccion(3, 4)

    val producto = m1 * m2
    println("$m1 * $m2 = $producto")
    println("Decimal: ${producto.aDecimal()}")

    val cociente = m1 / m2
    println("$m1 / $m2 = $cociente")
    println("Decimal: ${cociente.aDecimal()}")

    // ================================================
    // === Etapa 4: Comparaciones
    // ================================================
    println("\n=== COMPARACIONES ENTRE FRACCIONES (Etapa 4) ===")

    val c1 = Fraccion(1, 2)
    val c2 = Fraccion(2, 4)
    val c3 = Fraccion(3, 5)

    println("$c1 == $c2? ${c1 == c2}")
    println("$c1 > $c3? ${c1.esMayor(c3)}")
    println("$c1 < $c3? ${c1.esMenor(c3)}")

    // ================================================
    // === Etapa 4: Desde Decimal
    // ================================================
    println("\n=== CONVERSIÓN DESDE DECIMAL (Etapa 4) ===")

    val decimal = 0.75
    val fraccionDesdeDecimal = Fraccion.desdeDecimal(decimal)
    println("Fracción creada desde $decimal: $fraccionDesdeDecimal")
    println("Decimal equivalente: ${fraccionDesdeDecimal.aDecimal()}")
}