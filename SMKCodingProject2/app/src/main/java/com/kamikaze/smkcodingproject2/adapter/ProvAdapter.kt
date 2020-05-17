package com.kamikaze.smkcodingproject2.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kamikaze.smkcodingproject2.R
import com.kamikaze.smkcodingproject2.dataclass.ProvinsiItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.lokal_item2.*

class ProvAdapter (private val context: Context, private val items:List<ProvinsiItem>,
                           private val listener:(ProvinsiItem)-> Unit): RecyclerView.Adapter<ProvAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(context, LayoutInflater.from(context).inflate(
        R.layout.lokal_item2, parent, false))


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }


    class ViewHolder(val context: Context,override val containerView: View):
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item: ProvinsiItem, listener: (ProvinsiItem) -> Unit){
            val attributes =  item.attributes

            lokalProvinsi.text = attributes.provinsi
            lokalMeninggal2.text = attributes.kasusMeni.toString()
            lokalPositif2.text = attributes.kasusPosi.toString()
            lokalSembuh2.text = attributes.kasusSemb.toString()


            containerView.setOnClickListener{listener(item)}
        }
    }
}