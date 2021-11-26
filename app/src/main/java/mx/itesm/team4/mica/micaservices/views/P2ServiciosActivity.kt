package mx.itesm.team4.mica.micaservices.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.itesm.team4.mica.micaservices.api.api
import mx.itesm.team4.mica.micaservices.databinding.ActivityP2ServiciosBinding
import mx.itesm.team4.mica.micaservices.models.Servicio
import mx.itesm.team4.mica.micaservices.viewmodels.ListaServiciosVM
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class P2ServiciosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityP2ServiciosBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityP2ServiciosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

}