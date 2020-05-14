package com.kamikaze.smkcodingproject2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_hospital.*

class HospitalFragment : Fragment() {

    lateinit var listData : ArrayList<RujukanHospital>
    lateinit var listData2 : ArrayList<RujukanHospital>

    private fun dataHospital() {
        listData = ArrayList()
        listData.add(RujukanHospital("Rumah Sakit Umum Daerah (RSUD)  Dr. Saiful Anwar ",
            "Jalan Jaksa Agung Suprapto No.2, Klojen, Kecamatan Klojen, Kota Malang, Jawa Timur 65111",
            "(0341) 362101"))

        listData.add(RujukanHospital("RSU Islam Aisyiyah Malang",
            "Jl. Sulawesi No.16, Kasin, Kec. Klojen, Kota Malang, Jawa Timur 65117",
            "(0341) 326773"))

        listData.add(RujukanHospital("Rumah Sakit Tk. II dr. Soepraoen ",
            "JL. S. Supriyadi, No. 22, Sukun, Kec. Sukun, Kota Malang, Jawa Timur 65139",
            "(0341) 325111"))

        listData.add(RujukanHospital("Rumah Sakit Panti Waluya Sawahan ",
            "Jl. Nusakambangan No.56, Kasin, Kec. Klojen, Kota Malang, Jawa Timur 65117 \n",
            "(0341) 366033"))

        listData.add(RujukanHospital("Rumah Sakit Lavalette \n ",
            "l. W.R. Supratman No.10, Rampal Celaket, Kec. Klojen, Kota Malang, Jawa Timur 65111",
            "(0341) 470805"))

        listData2 = ArrayList()
        listData2.add(RujukanHospital("Rumah Sakit Umum Daerah Kanjuruhan  ",
            "Jl. Panji No.100, Krajan, Panggungrejo, Kec. Kepanjen, Malang, Jawa Timur 65163",
            " (0341) 395041"))

        listData2.add(RujukanHospital("Rumah Sakit Umum Wava Husada ",
            "Jl. Panglima Sudirman No.99A, Lemah Duwur, Dilem, Kec. Kepanjen, Malang, Jawa Timur 65163",
            "(0341) 393000"))

        listData2.add(RujukanHospital("Rumah Sakit Prima Husada Malang",
            "Jl. Raya Mondoroko, Mondoroko, Banjararum, Kec. Singosari, Malang, Jawa Timur 65153",
            "(0341) 458679"))

        listData2.add(RujukanHospital("RSU Universitas Muhammadiyah Malang ",
            "Jl. Raya Tlogomas No.45, Dusun Rambaan, Landungsari, Kec. Dau, Kota Malang, Jawa Timur 65144",
            "(0341) 561666"))

        listData2.add(RujukanHospital("RS Islam Gondanglegi ",
            "Jl. Hayam Wuruk No.66, Krajan, Gondanglegi Wetan, Kec. Gondanglegi, Malang, Jawa Timur 65174",
            "(0341) 879047"))


    }

    private fun hasilData() {
        rv_hospital.layoutManager = LinearLayoutManager(activity)
        rv_hospital.adapter = HospitalAdapter(activity!!, listData)
        rv_hospital2.layoutManager = LinearLayoutManager(activity)
        rv_hospital2.adapter = HospitalAdapter(activity!!, listData2)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hospital, container, false)
    }

    override fun onViewCreated
                (view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        dataHospital()
        hasilData()
    }
    override fun onDestroy(){
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}
