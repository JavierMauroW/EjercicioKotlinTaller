class ConsultaMedica(
       var diagnostico: String,
     var costoBase: Double,
       var incluyeMedicacion: Boolean,
        mascota: Mascota
) : Mascota(mascota.nombre, mascota.edad, mascota.peso) {

         fun calcularCosto(): Double {
            var costoTotal = costoBase
            if (incluyeMedicacion) {
              costoTotal *= 1.15 // Añadir 15% si incluye medicación
            }
                  return costoTotal
    }

    override fun describirMascota(): String {
                return super.describirMascota() + ", Diagnóstico: $diagnostico, Costo: ${calcularCosto()}"
    }
}