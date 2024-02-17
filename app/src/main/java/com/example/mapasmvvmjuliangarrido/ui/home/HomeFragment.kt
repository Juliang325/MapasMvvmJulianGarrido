package com.example.mapasmvvmjuliangarrido.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mapasmvvmjuliangarrido.adapter.PosicionAdapter
import com.example.mapasmvvmjuliangarrido.databinding.FragmentHomeBinding
import com.example.mapasmvvmjuliangarrido.model.Posicion
import com.example.mapasmvvmjuliangarrido.model.PosicionProvider

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var mutableListPosiciones:MutableList<Posicion> = PosicionProvider.posiciones.toMutableList()
    private lateinit var adapter:PosicionAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }


    private fun initRecyclerView(){

        adapter = PosicionAdapter(mutableListPosiciones, onClickDelete = {position -> onClickDelete(position)})
        binding.rvPosicion.layoutManager = LinearLayoutManager(context)
        binding.rvPosicion.adapter = adapter

    }

    private fun onClickDelete(position: Int) {
        mutableListPosiciones.removeAt(position)
        adapter.notifyItemRemoved(position)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}