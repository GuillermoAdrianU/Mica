package mx.itesm.Team4.nombre_proyecto.MicaServices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import mx.itesm.Team4.nombre_proyecto.MicaServices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val CODIGO_SIGN_IN = 200
    private lateinit var baseDatos: FirebaseDatabase
    private val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configurarEventos()
    }

    private fun configurarEventos(){
        binding.btnEntrar.setOnClickListener {
            val intEntrarServicios = Intent(this,P2ServiciosActivity::class.java)
            startActivity(intEntrarServicios)
        }

        binding.ibIngresarGoogle.setOnClickListener(){
            autenticar()
        }

        binding.btnRegistrar.setOnClickListener(){
            val intenRegistrar = Intent(this, RegistrarActivity::class.java)
            startActivity(intenRegistrar)
        }
    }

    private fun autenticar() {
        val providers = arrayListOf(AuthUI.IdpConfig.GoogleBuilder().build())
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            CODIGO_SIGN_IN
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CODIGO_SIGN_IN) {
            when (resultCode) {
                RESULT_OK -> {
                    val usuario =
                        FirebaseAuth.getInstance().currentUser
                    println("Bienvenido: ${usuario?.displayName}")
                    println("Correo: ${usuario?.email}")
                    println("UID: ${usuario?.uid}")
                    // Lanzar otra actividad
                    val intEntrarServicios = Intent(this,P2ServiciosActivity::class.java)
                    startActivity(intEntrarServicios)
                }
                RESULT_CANCELED -> {
                    println("Cancelado...")
                    val response =
                        IdpResponse.fromResultIntent(data)
                    println("Error: ${response?.error?.localizedMessage}")
                }
                else -> {
                    val response =
                        IdpResponse.fromResultIntent(data)
                    println("Error: ${response?.error?.errorCode}")
                }
            }
        }
    }
}