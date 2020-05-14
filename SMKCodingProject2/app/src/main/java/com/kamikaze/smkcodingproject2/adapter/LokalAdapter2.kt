package com.kamikaze.smkcodingproject2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kamikaze.smkcodingproject2.R
import com.kamikaze.smkcodingproject2.dataclass.LokalData2Item
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.lokal_item2.*

class LokalAdapter2(private val context: Context, private val items: List<LokalData2Item>,
                    private val listener2:(LokalData2Item)-> Unit):
    RecyclerView.Adapter<LokalAdapter2.ViewHolder2>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder2(context, LayoutInflater.from(context).inflate(
        R.layout.lokal_item2, parent, false))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {
        holder.bindItem(items.get(position), listener2)
    }

    class ViewHolder2(val context: Context,override val containerView: View):
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item:LokalData2Item, listener2: (LokalData2Item) -> Unit){


            lokalFID.text = item.fID.toString()
            lokalMeninggal2.text = item.kasusMeni.toString()
            lokalPositif2.text = item.kasusPosi.toString()
            lokalSembuh2.text = item.kasusSemb.toString()
            lokalProvinsi.text = item.provinsi
            lokalKode.text = item.kodeProvi.toString()

            containerView.setOnClickListener{listener2(item)}
        }
    }
}