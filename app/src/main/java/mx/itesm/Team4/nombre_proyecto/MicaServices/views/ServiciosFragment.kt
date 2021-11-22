package mx.itesm.Team4.nombre_proyecto.MicaServices.views

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.ListFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase



class ServiciosFragment : ListFragment() {
    private lateinit var binding: ServiciosFragment
    private var arrServiciosDestacados: MutableList<String> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        leerDatos()
    }

    private fun leerDatos() {
        val baseDatos = Firebase.database
        val referencia = baseDatos.getReference("Servicios/serviciosDatos")

        referencia.addListenerForSingleValueEvent(object: ValueEventListener{
        //referencia.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                arrServiciosDestacados.clear()
                for (registro in snapshot.children){
                    val serDestacado = registro.getValue(Servicio::class.java)
                    arrServiciosDestacados.add("${serDestacado?.Tipo}\n ${serDestacado?.Nombre}\n ${serDestacado?.Direccion}\n ${serDestacado?.Telefono}\n ${serDestacado?.correo}")
                }
                //adaptador
                val adaptador = ArrayAdapter(requireContext(), R.layout.simple_list_item_1,
                    arrServiciosDestacados)
                listAdapter = adaptador
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    fun  buscarDatos(busqueda:String) {
        arrServiciosDestacados.clear()

        val baseDatos = Firebase.database
        val referencia = baseDatos.getReference("Servicios/serviciosDatos/$busqueda")
        val data = referencia.get()

        data.addOnSuccessListener { snapshot ->
            for (registro in snapshot.children){
                val serDestacado = registro.getValue(Servicio::class.java)
                arrServiciosDestacados.add("${serDestacado?.Tipo}\n ${serDestacado?.Nombre}\n ${serDestacado?.Direccion}\n ${serDestacado?.Telefono}\n ${serDestacado?.correo}")
            }
            //adaptador
            val adaptador = ArrayAdapter(requireContext(), R.layout.simple_list_item_1,
                arrServiciosDestacados)
            listAdapter = adaptador
        }

    }


}