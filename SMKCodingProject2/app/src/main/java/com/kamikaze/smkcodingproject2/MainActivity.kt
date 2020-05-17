package com.kamikaze.smkcodingproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

            val iconNavigasi = arrayOf(R.drawable.ic_hospital, R.drawable.ic_global, R.drawable.ic_home, R.drawable.ic_lokal, R.drawable.ic_about)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = NavbarAdapter(this)
        view_pager.setAdapter(adapter)
        TabLayoutMediator(tb_navbar, view_pager,
        TabConfigurationStrategy {tab, position ->
            tab.icon = ResourcesCompat.getDrawable(resources, iconNavigasi[position],        null)
        }).attach()
    }
}
