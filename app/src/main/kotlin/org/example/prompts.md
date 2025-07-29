porque este codigo sigue ejecutandose aunque el usuario ponga una opcion invalida varias veces
por que este codigo sigue ejecutandose aunque el usuario ponga una opcion invalida varias veces

Esto pasa por la forma en que está hecho el bucle principal en main():

do {
...
opcion = input.toIntOrNull() ?: -1
...
} while (opcion != 0)

⚠️ qué está pasando

Cuando el usuario pone algo inválido, por ejemplo:

abc
!
---

el programa hace esto:

    scanner.nextLine() toma la entrada.

    input.toIntOrNull() devuelve null porque no puede convertir letras a número.

    Entonces, por el operador Elvis ?:, la variable opcion se convierte en -1.

Y como -1 != 0, el bucle sigue ejecutándose indefinidamente.

que esta mal en este codigo de programación dedicada a objetos
No, el código que me mandaste no tiene errores que impidan su ejecución. Compila y corre correctamente con Kotlin.

✅ Resumen claro:

    Sí se puede ejecutar: El programa arranca, muestra el menú, recibe entradas, crea fracciones y realiza operaciones.

    No hay errores de compilación ni excepciones no controladas que lo detengan desde el inicio.

porque este codigo se ejecuta infinitamente
El código de tu clase App.kt contiene un bucle do-while que controla la ejecución principal del programa:

do {
...
} while (opcion != 0)

Este bucle debería terminar cuando el usuario elige la opción 0, es decir, cuando el valor de opcion es 0. Sin embargo, puede ejecutarse infinitamente si nunca se llega correctamente a esa condición.
✅ Comportamiento esperado para salir del bucle:

    El menú se muestra.

    El usuario escribe 0.

    opcion se convierte en 0.

    Se imprime "¡Hasta luego!" y se rompe el bucle.

⚠️ Pero se ejecuta infinitamente si ocurre alguna de estas situaciones:

    Entrada inválida repetida (por ejemplo, letras o espacios):

        Si el usuario ingresa texto no convertible a entero (como "abc"), entonces:

val input = scanner.nextLine()
opcion = input.toIntOrNull() ?: -1

    toIntOrNull() devuelve null, y por eso opcion se convierte en -1.

    Como -1 != 0, el bucle sigue repitiéndose.

    El mensaje "Opción inválida..." aparece siempre, causando un bucle sin fin si el usuario nunca ingresa un número válido.