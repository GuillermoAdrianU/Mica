package mx.itesm.team4.mica.micaservices.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import mx.itesm.team4.mica.micaservices.databinding.ActivityPagarBinding

class Pagar : AppCompatActivity() {

    private lateinit var binding: ActivityPagarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configurarEventos()
    }

    private fun configurarEventos() {
        binding.btnContinuarDetalles.setOnClickListener {
            val intEntrarServicios = Intent(this, Detallescuenta::class.java)
            startActivity(intEntrarServicios)
            configurarEventos()
        }
    }
}


