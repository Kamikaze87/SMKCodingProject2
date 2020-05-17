package com.kamikaze.smkcodingproject2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kamikaze.smkcodingproject2.R
import com.kamikaze.smkcodingproject2.dataclass.Home3
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.home3.*


class HomeAdapter3 (private val context: Context, private val items :ArrayList<Home3>):
    RecyclerView.Adapter<HomeAdapter3.ViewHolder>(){

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int) = ViewHolder (
        LayoutInflater.from(context).inflate(R.layout.home3, parent,false)
    )

    override fun getItemCount(): Int{
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position:Int){
        holder.bindItem(items.get(position))
    }

    class ViewHolder(override val containerView:View):
        RecyclerView.ViewHolder(containerView),LayoutContainer{
        fun bindItem(item: Home3){
            home3Deskripsi.text = item.deskripsi

        }
    }

}