package mx.itesm.team4.mica.micaservices.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Servicio (
    @SerializedName("name")
    var Name:String = "",
    @SerializedName("fields")
    var Fields: ServicioFields = ServicioFields(Values(""),Values(""),Values(""),Values(""),Values(""),Values(""),Values(""),)
    ): Serializable

/*
    @SerializedName("Direccion")
    var Direccion:String = "",
    @SerializedName("Nombre")
    var Nombre:String = "",
    @SerializedName("Telefono")
    var Telefono:String = "",
    @SerializedName("Tipo")
    var Tipo:String = "",
    @SerializedName("Costo")
    var Costo:String = "",
    @SerializedName("Correo")
    var correo:String = "",
    @SerializedName("Imagen")
    var imagen:String = ""): Serializable
*/