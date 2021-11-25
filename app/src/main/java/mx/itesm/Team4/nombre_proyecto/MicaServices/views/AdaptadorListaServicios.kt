package mx.itesm.Team4.nombre_proyecto.MicaServices.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mx.itesm.Team4.nombre_proyecto.MicaServices.R
import mx.itesm.Team4.nombre_proyecto.MicaServices.models.Servicio

class AdaptadorListaServicios(var arrServicios: ArrayList<Servicio> ) :
    RecyclerView.Adapter<AdaptadorListaServicios.ServicioHolder>()
{
    //listener es un evento que escuche eventos del adaptador
    var listener: RenglonListener? = null

    //Pide las cajas/renglones
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicioHolder {
        val vistaRenglon =LayoutInflater.from(parent.context)
            .inflate(R.layout.renglonservicio, parent, false)

        return ServicioHolder(vistaRenglon) //una caja con un renglón
    }

    //Caja, ponle los datos que se quiere mostrar el renglón en "position"
    override fun onBindViewHolder(holder: ServicioHolder, position: Int) {
        holder.set(arrServicios[position])

        //listener
        val renglon = holder.itemView.findViewById<LinearLayout>(R.id.layoutRenglon) //linear layout
        val imagen = holder.itemView.findViewById<ImageView>(R.id.ivServicioRV)
        renglon.setOnClickListener {
            println("Click sobre: ${arrServicios[position]}")
            listener?.clickRenglon(position)  //solo si listener no es null --> ?
        }
        imagen.setOnClickListener {
            println("Click sobre: ${arrServicios[position]}")
            listener?.clickRenglon(position)  //solo si listener no es null --> ?
        }
    }

    override fun getItemCount(): Int {
        return arrServicios.size
    }

    fun actualizarDatos(lista: List<Servicio>?) {  //parámetro? es NULLABLE

        arrServicios.clear()              //Manejo de memoria, limpiar la memoria que no se usa
        if (lista != null){
            arrServicios.addAll(lista)
        }
        notifyDataSetChanged()      //avisar al adaptador que RECARGUE los datos

    }



    class ServicioHolder(view: View): RecyclerView.ViewHolder(view) {
        //Nombre pais
        private val tvNombreServicio = view.findViewById<TextView>(R.id.tvNombreServicioRV)  //Todos los ID son "R.id"

        //casos
        private val ivImagenServicio = view.findViewById<ImageView>(R.id.ivServicioRV)

        //con esta función se vana poblar los datos de cada una de las cajas(renglones)del recicler view
        fun set(servicio: Servicio){
            tvNombreServicio.text = servicio.Fields.Nombre.stringValue
            Glide
                .with(itemView)
                .load(servicio.Fields.imagen)
                .placeholder(R.drawable.ic_launcher_background)
                .into(ivImagenServicio)
        }

    }



}

