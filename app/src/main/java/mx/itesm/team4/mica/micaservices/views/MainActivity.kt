package mx.itesm.team4.mica.micaservices.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import mx.itesm.team4.mica.micaservices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val CODIGO_SIGN_IN = 200
    private lateinit var baseDatos: FirebaseDatabase
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        mAuth = FirebaseAuth.getInstance()
        setContentView(view)
        configurarEventos()
    }

    private fun configurarEventos(){
        binding.btnEntrar.setOnClickListener {
            val intEntrarServicios = Intent(this, P2ServiciosActivity::class.java)
            if(binding.etCorre.text?.isNotBlank() == true) {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(
                        binding.etCorre.text.toString(),
                        binding.etContrase.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            startActivity(intEntrarServicios)
                        } else {
                            showAlert()
                        }
                    }
            }else{
                showAlert()
            }



        }

        binding.ibIngresarGoogle.setOnClickListener(){
            autenticarGoogle()
        }

        binding.btnRegistrar.setOnClickListener(){
            autenticar()
        }
    }

    fun signIn(v: View){
        autenticarGoogle()
    }

    private fun autenticar() {
        val providers = arrayListOf(AuthUI.IdpConfig.EmailBuilder().build())
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            CODIGO_SIGN_IN
        )
    }

    private fun autenticarGoogle() {
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
                    //val intEntrarServicios = Intent(this, P2ServiciosActivity::class.java)
                    //startActivity(intEntrarServicios)
                    val intEntrarServicios = Intent(this, P2ServiciosActivity::class.java)
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

    override fun onStart() {
        super.onStart()
        val usuario = mAuth.currentUser
        if (usuario != null){
            println("Bienvenido")
            val intInicioSesion = Intent(this, P2ServiciosActivity::class.java)
            startActivity(intInicioSesion)
        }else{
            println("Hacer Login......")
        }
    }


    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al autenticar al usuario")
        builder.setPositiveButton("Aceptar", null)

        val dialog = builder.create()
        dialog.show()


    }
    //finaliza actividad
    override fun finishActivity(requestCode: Int) {
        super.finishActivity(requestCode)
    }

    //double tap exit
    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper()).postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }
}