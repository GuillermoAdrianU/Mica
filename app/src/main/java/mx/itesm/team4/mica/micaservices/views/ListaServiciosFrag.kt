package mx.itesm.team4.mica.micaservices.views

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import mx.itesm.team4.mica.micaservices.databinding.ListaServiciosFragmentBinding
import mx.itesm.team4.mica.micaservices.models.Servicio
import mx.itesm.team4.mica.micaservices.models.ServicioFields
import mx.itesm.team4.mica.micaservices.models.Values
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
            binding.progressBar2.visibility = View.GONE
        }

        /*binding.searchText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }

        })*/

    }


    private fun registrarEventos() {
        viewModel.descargarServicios()

        binding.ibBuscar.setOnClickListener {
            print("ENTRO")
            filtrarDatos()
        }
    }

    override fun clickRenglon(position: Int) {
        val servicioSeleccionado = adaptadorListaServicios.arrServicios[position]
        val action = ListaServiciosFragDirections.actionListaServiciosFragToContactar(servicioSeleccionado)
        findNavController().navigate(action)
    }

    private fun filtrarDatos(){
        val iterador = viewModel.arrayServicios.value
        var nuevaLista = arrayListOf<Servicio>()

        if (iterador != null) {
            iterador.forEach { servicio ->
                if (servicio.Fields.Nombre.stringValue == binding.searchText.text.toString()) {
                    nuevaLista.add(servicio)
                } else if (servicio.Fields.Tipo.stringValue == binding.searchText.text.toString()) {
                    nuevaLista.add(servicio)
                } else {
                    print(servicio.Fields.Nombre.stringValue)
                }
            }
        }

        viewModel.arrayServicios.value = nuevaLista



    }


}