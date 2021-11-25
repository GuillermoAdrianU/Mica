package mx.itesm.team4.mica.micaservices.views

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import mx.itesm.team4.mica.micaservices.databinding.ActivityDetallescuentaBinding


class Detallescuenta : AppCompatActivity() {

    private lateinit var binding: ActivityDetallescuentaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallescuentaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configurarEventos()
    }

    private fun configurarEventos() {
        binding.btnSalir.setOnClickListener {
            val intEntrarServicios = Intent(this, P2ServiciosActivity::class.java)
            startActivity(intEntrarServicios)
        }
        binding.EnviarRecibo.setOnClickListener {
            if (!binding.etMail.getText().toString().isEmpty()) {
                val mailIntent = Intent(Intent.ACTION_SENDTO)
                val email: String = binding.etMail.getText().toString()
                mailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Recibo de Pago")
                mailIntent.putExtra(Intent.EXTRA_TEXT, "Gracias por utilizar este servicio")
                //mailIntent.setType("message/rfc822")
                mailIntent.setData(Uri.parse("mailto:"))
                if (mailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mailIntent)
                } else {
                    Toast.makeText(this,
                        "There is no application that supports this action",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }
    }
}