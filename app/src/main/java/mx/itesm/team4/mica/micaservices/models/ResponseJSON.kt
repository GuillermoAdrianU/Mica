package mx.itesm.team4.mica.micaservices.models

import com.google.gson.annotations.SerializedName

data class ResponseJSON(
    @SerializedName("documents")
    var documents: ArrayList<Servicio> = arrayListOf()
)
