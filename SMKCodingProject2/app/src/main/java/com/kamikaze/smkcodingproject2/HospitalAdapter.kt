package com.kamikaze.smkcodingproject2
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.hospital_item.*

class HospitalAdapter (private val context:Context, private val items :ArrayList<RujukanHospital>):
RecyclerView.Adapter<HospitalAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int) = ViewHolder (
        LayoutInflater.from(context).inflate(R.layout.hospital_item, parent,false)
    )

    override fun getItemCount(): Int{
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position:Int){
        holder.bindItem(items.get(position))
    }

    class ViewHolder(override val containerView:View):
            RecyclerView.ViewHolder(containerView),LayoutContainer{
        fun bindItem(item: RujukanHospital){
            hospitalName.text = item.nama
            hospitalAlamat.text = item.alamat
            hospitalTelp.text = item.telp
        }
    }

}