package mx.itesm.Team4.nombre_proyecto.MicaServices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.itesm.Team4.nombre_proyecto.MicaServices.databinding.ActivityMainBinding
import mx.itesm.Team4.nombre_proyecto.MicaServices.databinding.ActivityRegistrarBinding

class RegistrarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityRegistrarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}