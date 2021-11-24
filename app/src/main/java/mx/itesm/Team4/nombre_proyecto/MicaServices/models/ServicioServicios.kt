package mx.itesm.Team4.nombre_proyecto.MicaServices.models

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class ServicioServicios {
    fun leerServicios(): List<Servicio> {
        val arrServicios: MutableList<Servicio> = mutableListOf()
        val baseDatos = Firebase.database
        val referencia = baseDatos.getReference("Servicios/serviciosDatos")

        referencia.addListenerForSingleValueEvent(object: ValueEventListener {
            //referencia.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                arrServicios.clear()
                for (registro in snapshot.children){
                    val servicio = registro.getValue(Servicio::class.java)
                    arrServicios.add(servicio!!)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

        return arrServicios
    }
}