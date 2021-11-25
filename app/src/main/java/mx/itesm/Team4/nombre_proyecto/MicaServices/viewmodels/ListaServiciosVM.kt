package mx.itesm.Team4.nombre_proyecto.MicaServices.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import mx.itesm.Team4.nombre_proyecto.MicaServices.api.api
import mx.itesm.Team4.nombre_proyecto.MicaServices.models.ResponseJSON
import mx.itesm.Team4.nombre_proyecto.MicaServices.models.Servicio
import mx.itesm.Team4.nombre_proyecto.MicaServices.models.ServicioServicios
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListaServiciosVM : ViewModel() {
    //Modelo
    private val servicioServicios = ServicioServicios()

    //Variables observables
    val arrayServicios = MutableLiveData<List<Servicio>>()


    //Retrofit
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://firestore.googleapis.com/v1/")
            //.addConverterFactory(ScalarsConverterFactory.create()) //conbvertifdor strings
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val serviciosApi by lazy {
        retrofit.create(api::class.java)
    }

    //Eventos
    fun leerServicios(){
        arrayServicios.value = servicioServicios.leerServicios()
        //descargarDatosGloables
        descargarServicios()
    }

    fun descargarServicios() {
        val call= serviciosApi.descargarListaServicios()
        call.enqueue(object: Callback<ResponseJSON>{
            override fun onResponse(call: Call<ResponseJSON>, response: Response<ResponseJSON>) {
                print("Servicio: ${response.body()}")
                arrayServicios.value = response.body()?.documents
            }

            override fun onFailure(call: Call<ResponseJSON>, t: Throwable) {
                println("Error en la lsita de datos ${t.message.toString()}")
            }

        })

    }

}