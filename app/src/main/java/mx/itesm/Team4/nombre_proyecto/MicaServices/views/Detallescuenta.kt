package mx.itesm.Team4.nombre_proyecto.MicaServices.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.itesm.Team4.nombre_proyecto.MicaServices.databinding.ActivityDetallescuentaBinding


class Detallescuenta : AppCompatActivity() {

    private lateinit var binding: ActivityDetallescuentaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallescuentaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configurarEventos()
    }

private fun configurarEventos(){
    binding.btnSalir.setOnClickListener {
        val intEntrarServicios = Intent(this, P2ServiciosActivity::class.java)
        startActivity(intEntrarServicios)
        }
    }
}