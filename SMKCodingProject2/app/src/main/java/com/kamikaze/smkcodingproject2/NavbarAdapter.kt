package com.kamikaze.smkcodingproject2
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class NavbarAdapter (fragmentActivity : FragmentActivity) :

                    FragmentStateAdapter(fragmentActivity){

        private val JUMLAH_NAVIGASI = 5

    override fun createFragment(position:Int): Fragment {
        when(position){
            0 -> {return HospitalFragment()}
            1 -> {return GlobalFragment()}
            2 -> {return HomeFragment()}
            3 -> {return LokalFragment()}
            4 -> {return AboutFragment()}
            else -> {
                return HomeFragment()
            }
        }
    }


    override fun getItemCount(): Int{
        return JUMLAH_NAVIGASI
    }
}