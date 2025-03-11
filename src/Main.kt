import java.util.*

fun main() {
      val scanner = Scanner(System.`in`)
    val consultas = mutableListOf<ConsultaMedica>()

    while (true) {
           println("\n--- Menú de Veterinaria ---")
        println("1. Registrar consulta médica")
         println("2. Mostrar historial de consultas")
        println("3. Modificar datos de consulta")
         println("4. Calcular costo total de consultas")
            println("5. Salir")
         print("Seleccione una opción: ")


                when (scanner.nextInt()) {
            1 -> {
                print("Ingrese el nombre de la mascota: ")
                val nombre = scanner.next()

                print("Ingrese la edad de la mascota: ")
                val edad = scanner.nextInt()

                print("Ingrese el peso de la mascota: ")
                val peso = scanner.nextDouble()

                print("Ingrese el diagnóstico: ")
                val diagnostico = scanner.next()

                print("Ingrese el costo base: ")
                val costoBase = scanner.nextDouble()
                print("¿Incluye medicación? (true/false): ")
                val incluyeMedicacion = scanner.nextBoolean()


                val mascota = Mascota(nombre, edad, peso)
                val consulta = ConsultaMedica(diagnostico, costoBase, incluyeMedicacion, mascota)
                consultas.add(consulta)
                println("Consulta registrada: ${consulta.describirMascota()}")
            }
            2 -> {

                 if (consultas.isEmpty()) {
                    println("No hay consultas registradas.")
                } else {


                   println("Historial de consultas:")
                    for (consulta in consultas) {
                        println(consulta.describirMascota())
                    }
                }
            }
            3 -> {

                print("Ingrese el nombre de la mascota para modificar: ")
                 val nombre = scanner.next()
                  val consulta = consultas.find { it.nombre.equals(nombre, ignoreCase = true) }
                     if (consulta != null) {
                         print("Ingrese el nuevo peso: ")
                    val nuevoPeso = scanner.nextDouble()
                    print("Ingrese la nueva edad: ")
                    val nuevaEdad = scanner.nextInt()
                    consulta.actualizarPeso(nuevoPeso)
                        consulta.edad = nuevaEdad
                    println("Datos de consulta modificados: ${consulta.describirMascota()}")
                } else {


                    println("No se encontró la consulta para la mascota con nombre $nombre.")
                }
            }
            4 -> {

                     val costoTotal = consultas.sumOf { it.calcularCosto() }
                println("Costo total de todas las consultas: $costoTotal")
            }
            5 -> {
                println("Saliendo del sistema.")
                         return
            }
              else -> {
                println("Opción no válida. Intente de nuevo.")
            }
        }
    }
}