package mx.itesm.Team4.nombre_proyecto.MicaServices.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.itesm.Team4.nombre_proyecto.MicaServices.databinding.ActivityP2ServiciosBinding


class P2ServiciosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityP2ServiciosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityP2ServiciosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


}