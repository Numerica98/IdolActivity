package com.example.idol

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.idol.data.Idol
import kotlinx.android.synthetic.main.item_idol.view.*

class IdolAdapter (context: Context, var clickListener: (Idol) -> Unit): RecyclerView.Adapter<IdolAdapter.ViewHolder>() {
    private var idols = emptyList<Idol>()
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_idol, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = idols.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(idols[position] ,clickListener)

    fun updateList(newIdols:List<Idol>){
        this.idols=newIdols
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(idol: Idol,clickListener: (Idol) -> Unit) = with(itemView) {
            tv_nombre.text= idol.nombre
            this.setOnClickListener() { clickListener(idol)}
        }

    }
}