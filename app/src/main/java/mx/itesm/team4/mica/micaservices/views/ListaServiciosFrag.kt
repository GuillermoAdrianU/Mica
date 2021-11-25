package mx.itesm.team4.mica.micaservices.views

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import mx.itesm.team4.mica.micaservices.databinding.ListaServiciosFragmentBinding
import mx.itesm.team4.mica.micaservices.viewmodels.ListaServiciosVM

class ListaServiciosFrag : Fragment(), RenglonListener {

    companion object {
        fun newInstance() = ListaServiciosFrag()
    }

    private lateinit var viewModel: ListaServiciosVM

    //Binding
    private lateinit var binding: ListaServiciosFragmentBinding

    //Adaptador
    private val adaptadorListaServicios = AdaptadorListaServicios(arrayListOf()) //Vacio

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListaServiciosFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListaServiciosVM::class.java)
        configurarLista()  //configurar recicler view
        registrarObservadores()
        registrarEventos()
    }

    private fun configurarLista() {
        binding.rvServicios.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adaptadorListaServicios
        }

        adaptadorListaServicios.listener= this
    }

    private fun registrarObservadores() {
        viewModel.arrayServicios.observe(viewLifecycleOwner){lista ->
            adaptadorListaServicios.actualizarDatos(lista)
        }
    }


    private fun registrarEventos() {
        viewModel.descargarServicios()
    }

    override fun clickRenglon(position: Int) {
        val servicioSeleccionado = adaptadorListaServicios.arrServicios[position]
        val action = ListaServiciosFragDirections.actionListaServiciosFragToContactar(servicioSeleccionado)
        findNavController().navigate(action)
    }

}