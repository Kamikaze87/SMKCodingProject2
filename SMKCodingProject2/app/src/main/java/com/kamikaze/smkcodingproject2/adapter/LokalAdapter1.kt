package com.kamikaze.smkcodingproject2.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kamikaze.smkcodingproject2.R
import com.kamikaze.smkcodingproject2.dataclass.LokalData1Item
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.lokal_item.*

class LokalAdapter1 (private val context: Context, private val items:List<LokalData1Item>,
    private val listener:(LokalData1Item)-> Unit):
    RecyclerView.Adapter<LokalAdapter1.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(context, LayoutInflater.from(context).inflate(
            R.layout.lokal_item, parent, false))


        override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }


    class ViewHolder(val context: Context,override val containerView: View):
            RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item: LokalData1Item, listener: (LokalData1Item) -> Unit){
            lokalMeninggal.text = item.meninggal
            lokalPositif.text = item.positif
            lokalSembuh.text = item.sembuh


            containerView.setOnClickListener{listener(item)}
        }
    }

}
