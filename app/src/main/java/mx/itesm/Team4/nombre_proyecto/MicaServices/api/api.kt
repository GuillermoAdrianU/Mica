package mx.itesm.Team4.nombre_proyecto.MicaServices.api

import mx.itesm.Team4.nombre_proyecto.MicaServices.models.ResponseJSON
import mx.itesm.Team4.nombre_proyecto.MicaServices.models.Servicio
import retrofit2.Call
import retrofit2.http.GET

interface api {

    //https://firestore.googleapis.com/v1/
    //micaservices-a7d33
    ///projects/YOUR_PROJECT_ID/databases/(default)/documents/cities/LA

    @GET("projects/micaservices-a7d33/databases/(default)/documents/Servicios")
    fun descargarListaServicios() : Call<ResponseJSON>
}