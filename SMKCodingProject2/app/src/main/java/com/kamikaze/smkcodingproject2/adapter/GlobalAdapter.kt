package com.kamikaze.smkcodingproject2.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kamikaze.smkcodingproject2.R
import com.kamikaze.smkcodingproject2.dataclass.TotalGlobalItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.global_item.*

class GlobalAdapter (private val context: Context, private val items:List<TotalGlobalItem>,
                     private val listener:(TotalGlobalItem)-> Unit): RecyclerView.Adapter<GlobalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(context, LayoutInflater.from(context).inflate(
        R.layout.global_item, parent, false))


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }


    class ViewHolder(val context: Context,override val containerView: View):
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item: TotalGlobalItem, listener: (TotalGlobalItem) -> Unit){
            val global =  item.attributes

            negara.text = global.countryRegion
            positif.text = global.confirmed.toString()
            meninggal.text = global.deaths.toString()
            sembuh.text = global.recovered.toString()
            aktif.text = global.active.toString()


            containerView.setOnClickListener{listener(item)}
        }
    }
}