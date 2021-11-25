package mx.itesm.Team4.nombre_proyecto.MicaServices.models

import com.google.gson.annotations.SerializedName

data class ResponseJSON(
    @SerializedName("documents")
    var documents: ArrayList<Servicio> = arrayListOf()
)
