package mx.itesm.Team4.nombre_proyecto.MicaServices.views

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import mx.itesm.Team4.nombre_proyecto.MicaServices.databinding.ServicioFragmentBinding
import mx.itesm.Team4.nombre_proyecto.MicaServices.viewmodels.ServicioVM

class ServicioFrag : Fragment() {

    companion object {
        fun newInstance() = ServicioFrag()
    }

    private val viewModel: ServicioVM by viewModels()
    private lateinit var binding  : ServicioFragmentBinding
    private val args : ServicioFragArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ServicioFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvNombreCon.text = args.servicioSeleccionado.Fields.Direccion.stringValue
        binding.tvTipoCon.text = args.servicioSeleccionado.Fields.Tipo.stringValue
        binding.tvTelefonoCon.text = args.servicioSeleccionado.Fields.Telefono.stringValue
        binding.tvCostoCon.text = args.servicioSeleccionado.Fields.Costo.stringValue
        binding.tvDireccionCon.text = args.servicioSeleccionado.Fields.Direccion.stringValue

        configurarEventos()
        configurarObservadores()
    }

    private fun configurarObservadores() {

    }

    private fun configurarEventos() {
        binding.btnConfirmar.setOnClickListener {
            val action = ServicioFragDirections.actionServicioFragToPagar()
            findNavController().navigate(action)
        }

    }

}