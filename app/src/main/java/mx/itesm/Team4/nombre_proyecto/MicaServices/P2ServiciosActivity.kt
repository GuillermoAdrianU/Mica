package mx.itesm.Team4.nombre_proyecto.MicaServices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.itesm.Team4.nombre_proyecto.MicaServices.databinding.ActivityP2ServiciosBinding


class P2ServiciosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityP2ServiciosBinding
    private lateinit var fragmentoServicios: ServicioDestacadoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityP2ServiciosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configurarEventos()
    }

    private fun configurarEventos(){
        binding.btnContactar.setOnClickListener {
            val intEntrarServicios = Intent(this,contactar::class.java)
            startActivity(intEntrarServicios)
        }

        binding.btnBuscar.setOnClickListener {
            fragmentoServicios.buscarDatos(binding.buscarServicio.toString())
        }

    }

}