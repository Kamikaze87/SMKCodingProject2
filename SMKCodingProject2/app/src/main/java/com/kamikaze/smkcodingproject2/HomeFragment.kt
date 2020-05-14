package com.kamikaze.smkcodingproject2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import com.kamikaze.smkcodingproject2.adapter.HomeAdapter
import com.kamikaze.smkcodingproject2.dataclass.Home
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_hospital.*

class HomeFragment : Fragment() {

    lateinit var listData : ArrayList<Home>

    private fun dataHome() {
        listData = ArrayList()
        listData.add(Home("Tentang COVID-19",
            "Virus Corona atau severe acute respiratory syndrome coronavirus 2 (SARS-CoV-2) adalah virus yang menyerang sistem pernapasan", "Penyakit karena " +
                    "infeksi virus ini disebut COVID-19"," Virus Corona bisa menyebabkan gangguan ringan pada sistem pernapasan", "infeksi paru-paru yang berat hingga kematian."))

        listData = ArrayList()
        listData.add(Home("Gejala Virus COVID-19",
            "Gejala Umum :",
            "Demam",
            "Batuk Kering",
            "Sesak Napas"))

        listData = ArrayList()
        listData.add(Home("Kapan Harus Periksa Ke Dokter?", "Segera lakukan isolasi mandiri bila Anda mengalami gejala infeksi virus Corona (COVID-19) seperti yang telah disebu" +
                "tkan di atas", "terutama jika dalam 2 minggu terakhir Anda berada di daerah yang memiliki kasus COVID-19 atau kontak dengan penderita COVID-19. " +
                "Setelah itu hubungi hotline COVID-19 di 119 Ext. 9 untuk mendapatkan pengarahan lebih lanjut.","Bila Anda mungkin terpapar virus Corona tapi tidak mengalami gejala apa pun",
            "Anda tidak perlu memeriksakan diri ke rumah sakit, cukup tinggal di rumah selama 14 hari dan membatasi kontak dengan orang lain. "))

        listData = ArrayList()
        listData.add(Home("Penyebab COVID-19","Ada dugaan bahwa virus Corona awalnya ditularkan dari hewan ke manusia. Namun, kemudian diketahui bahwa virus Corona juga menular dari manusia ke manusia." +
                "Seseorang dapat tertular COVID-19 melalui berbagai cara, yaitu:",
            "Tidak sengaja menghirup percikan ludah (droplet) yang keluar saat penderita COVID-19 batuk atau bersin",
            "Memegang mulut atau hidung tanpa mencuci tangan terlebih dulu setelah menyentuh benda yang terkena cipratan ludah penderita COVID-19",
            "Kontak jarak dekat dengan penderita COVID-19"))



    }

    private fun hasilData() {
        rv_home.layoutManager = LinearLayoutManager(activity)
        rv_home.adapter = HomeAdapter(activity!!, listData)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated
                (view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        dataHome()
        hasilData()
    }
    override fun onDestroy(){
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}
