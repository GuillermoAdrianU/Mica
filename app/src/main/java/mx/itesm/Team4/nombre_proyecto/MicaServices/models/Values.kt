package mx.itesm.Team4.nombre_proyecto.MicaServices.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Values (
    @SerializedName("stringValue")
    var stringValue:String = "") : Serializable