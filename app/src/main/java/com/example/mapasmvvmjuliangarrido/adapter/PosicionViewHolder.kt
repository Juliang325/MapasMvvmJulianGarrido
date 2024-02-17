package com.example.mapasmvvmjuliangarrido.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.mapasmvvmjuliangarrido.databinding.ItemPosicionBinding
import com.example.mapasmvvmjuliangarrido.model.Posicion

class PosicionViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemPosicionBinding.bind(view)


    fun render(p: Posicion, onClickDelete: (Int) -> Unit){
        binding.tvName.text = "hola"
        binding.tvLatitude.text = p.latitude.toString()
        binding.tvLongitude.text = p.longitude.toString()
        binding.btnBorrar.setOnClickListener{onClickDelete(adapterPosition)}

    }
}

