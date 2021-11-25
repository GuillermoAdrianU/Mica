package mx.itesm.team4.mica.micaservices.views

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import mx.itesm.team4.mica.micaservices.R
import mx.itesm.team4.mica.micaservices.databinding.ActivityContactarBinding
import mx.itesm.team4.mica.micaservices.models.Servicio


class contactar : AppCompatActivity() {

    private lateinit var binding: ActivityContactarBinding
    private val args : contactarArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        llenarDatos()
        configurarEventos()
    }

    private fun llenarDatos() {
        binding.tvNombre.text = args.servicioSelecionado.Fields.Nombre.stringValue
        binding.tvCosto.text = args.servicioSelecionado.Fields.Costo.stringValue
        binding.tvDireccion.text = args.servicioSelecionado.Fields.Direccion.stringValue
        binding.tvTipo.text = args.servicioSelecionado.Fields.Tipo.stringValue
        binding.tvTelefono.text= args.servicioSelecionado.Fields.Telefono.stringValue

        Glide
            .with(this)
            .load(args.servicioSelecionado.Fields.imagen.stringValue)
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.imageView5)

    }


    private fun configurarEventos(){
        binding.btncontinuar.setOnClickListener {
            val intEntrarServicios = Intent(this, Pagar::class.java)
            startActivity(intEntrarServicios)
        }

    }

}