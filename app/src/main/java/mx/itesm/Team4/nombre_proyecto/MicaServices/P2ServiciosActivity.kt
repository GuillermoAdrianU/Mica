package mx.itesm.Team4.nombre_proyecto.MicaServices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.itesm.Team4.nombre_proyecto.MicaServices.databinding.ActivityP2ServiciosBinding

class P2ServiciosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityP2ServiciosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityP2ServiciosBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_p2_servicios)
        configurarEventos()
    }

    private fun configurarEventos(){
        binding.btnContinuar.setOnClickListener {
            val intEntrarServicios = Intent(this,contactar::class.java)
            startActivity(intEntrarServicios)
        }

    }

}