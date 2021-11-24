package mx.itesm.Team4.nombre_proyecto.MicaServices.models

import java.io.Serializable

data class Servicio (var Direccion:String = "",
                     var Nombre:String = "",
                     var Telefono:String = "",
                     var Tipo:String = "",
                     var Costo:String = "",
                     var correo:String = "",
                     var imagen:String = ""): Serializable