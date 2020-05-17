package com.kamikaze.smkcodingproject2.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kamikaze.smkcodingproject2.R
import com.kamikaze.smkcodingproject2.dataclass.Home2
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.home2.*

class HomeAdapter2 (private val context: Context, private val items :ArrayList<Home2>):
    RecyclerView.Adapter<HomeAdapter2.ViewHolder>(){

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int) = ViewHolder (
        LayoutInflater.from(context).inflate(R.layout.home2, parent,false)
    )

    override fun getItemCount(): Int{
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position:Int){
        holder.bindItem(items.get(position))
    }

    class ViewHolder(override val containerView:View):
        RecyclerView.ViewHolder(containerView),LayoutContainer{
        fun bindItem(item: Home2){
            home2Name.text = item.judul
            home2Deskripsi.text = item.deskripsi
            home2List1.text = item.list1
            home2List2.text = item.list2
            home2List3.text = item.list3

        }
    }

}