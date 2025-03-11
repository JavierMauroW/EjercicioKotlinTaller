open class Mascota(
     var nombre: String,
    var edad: Int,
    var peso: Double
) {
              fun actualizarPeso(nuevoPeso: Double) {
                    peso = nuevoPeso
    }

           fun incrementarEdad() {
                edad += 1
    }

              open fun describirMascota(): String {
               return "Nombre: $nombre, Edad: $edad años, Peso: $peso kg"
    }
}