package mx.itesm.team4.mica.micaservices.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ServicioFields (
    @SerializedName("Direccion")
    var Direccion:Values = Values(""),
    @SerializedName("Nombre")
    var Nombre:Values = Values(""),
    @SerializedName("Telefono")
    var Telefono:Values = Values(""),
    @SerializedName("Tipo")
    var Tipo:Values = Values(""),
    @SerializedName("Costo")
    var Costo:Values = Values(""),
    @SerializedName("Correo")
    var correo:Values = Values(""),
    @SerializedName("Imagen")
    var imagen:Values = Values("")): Serializable