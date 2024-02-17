package com.example.mapasmvvmjuliangarrido.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mapasmvvmjuliangarrido.R
import com.example.mapasmvvmjuliangarrido.model.Posicion

class PosicionAdapter(private val posiconList: List<Posicion>, private val onClickDelete:(Int) -> Unit) : RecyclerView.Adapter<PosicionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosicionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PosicionViewHolder(layoutInflater.inflate(R.layout.item_posicion, parent, false))
    }


    override fun onBindViewHolder(holder: PosicionViewHolder, position: Int) {
        val item = posiconList[position]
        holder.render(item, onClickDelete)
    }


    override fun getItemCount(): Int = posiconList.size
}
