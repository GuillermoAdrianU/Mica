package mx.itesm.team4.mica.micaservices.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Values (
    @SerializedName("stringValue")
    var stringValue:String = "") : Serializable