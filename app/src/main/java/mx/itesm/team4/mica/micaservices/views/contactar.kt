package mx.itesm.team4.mica.micaservices.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.itesm.team4.mica.micaservices.databinding.ActivityContactarBinding


class contactar : AppCompatActivity() {

    private lateinit var binding: ActivityContactarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configurarEventos()
    }

    private fun configurarEventos(){
        binding.btncontinuar.setOnClickListener {
            val intEntrarServicios = Intent(this, Pagar::class.java)
            startActivity(intEntrarServicios)
        }

    }

}