package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val data:Array<RectcleData> ,private val context:Context) : RecyclerView.Adapter<Adapter.Holderview>() {
    private var onItemClick:((Int)->Unit)?=null
    override fun onBindViewHolder(holder: Holderview, position: Int) {
       var item:RectcleData=data[position]
       holder.Image.setImageResource(item.image)
        holder.title.text=item.title
        holder.views.text=item.views.toString()+" Views"
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holderview {
        return Holderview(LayoutInflater.from(parent.context).inflate(R.layout.custemview,parent,false))
    }
    fun setOnClickLisener(litener:(Int)->Unit){
        onItemClick=litener
    }
    override fun getItemCount(): Int {
        return data.size
    }
     fun getItem(position:Int):RectcleData{
        return data[position]
    }
      class Holderview(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val Image:ImageView=itemView.findViewById(R.id.cusimgs)
         val title:TextView=itemView.findViewById(R.id.cuscity)
         val views:TextView=itemView.findViewById(R.id.cusviews)


    }
}