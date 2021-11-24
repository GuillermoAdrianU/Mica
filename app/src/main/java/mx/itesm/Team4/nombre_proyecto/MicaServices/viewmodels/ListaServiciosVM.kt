package mx.itesm.Team4.nombre_proyecto.MicaServices.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import mx.itesm.Team4.nombre_proyecto.MicaServices.models.Servicio
import mx.itesm.Team4.nombre_proyecto.MicaServices.models.ServicioServicios

class ListaServiciosVM : ViewModel() {
    //Modelo
    private val servicioPaises = ServicioServicios()

    //Variables observables
    val arrayServicios = MutableLiveData<List<Servicio>>()

    //Eventos
    fun leerServicios(){
        arrayServicios.value = servicioPaises.leerServicios()
        //descargarDatosGloables
        descargarServicios()
    }

    fun descargarServicios() {
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
        
        arrayServicios.value = arrServicios

    }

}