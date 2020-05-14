package com.kamikaze.smkcodingproject2.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kamikaze.smkcodingproject2.R
import com.kamikaze.smkcodingproject2.dataclass.GlobalData
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.global_item.*

class GlobalAdapter (private val context: Context, private val items:List<GlobalData>,
                     private val listener:(GlobalData)-> Unit):
    RecyclerView.Adapter<GlobalAdapter.ViewHolder>() {

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
        fun bindItem(item: GlobalData, listener: (GlobalData) -> Unit){
            txtnama.text = item.name
            hasil.text = item.value


            containerView.setOnClickListener{listener(item)}
        }
    }

}