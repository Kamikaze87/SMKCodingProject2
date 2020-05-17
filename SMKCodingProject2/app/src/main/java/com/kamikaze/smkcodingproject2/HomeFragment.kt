package com.kamikaze.smkcodingproject2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import com.kamikaze.smkcodingproject2.adapter.HomeAdapter
import com.kamikaze.smkcodingproject2.adapter.HomeAdapter2
import com.kamikaze.smkcodingproject2.adapter.HomeAdapter3
import com.kamikaze.smkcodingproject2.dataclass.Home
import com.kamikaze.smkcodingproject2.dataclass.Home2
import com.kamikaze.smkcodingproject2.dataclass.Home3
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_hospital.*

class HomeFragment : Fragment() {

    lateinit var listData : ArrayList<Home>
    lateinit var listData2 : ArrayList<Home2>
    lateinit var listData3 : ArrayList<Home3>

    private fun dataHome() {
        listData = ArrayList()
        listData.add(Home("Gejala Virus COVID-19",
            "-Sakit tenggorokan",
            "-Demam",
            "-Batuk Kering",
            "-Sesak Napas(pada kasus yang lebih serius)",
        "-Pilek"))

      listData.add(Home("Pencegahan Virus COVID-19",
          "-Cuci Tangan lebih sering",
      "-Siku untuk menutup mulut saat batuk",
      "-Wajah Jangan disentuh",
      "-JarakJaga jarak aman",
      "-RumahUsahakan di rumah saja\n"))

        listData.add(Home("Perawatan",
        "Jika Anda memiliki gejala ringan, beristirahatlah di rumah hingga benar-benar pulih. Anda dapat mengurangi gejala penyakit jika:",
        "-Beristirahat atau tidur",
        "-Menjaga badan tetap hangat",
        "-Minum yang banyak",
        "-Menjaga ruangan cukup lembab atau mandi dengan air hangat untuk membantu meringankan sakit tenggorokan dan batuk.\n"))

    listData.add(Home("Pengobatan(COVID-19)",
    "ada beberapa langkah yang dapat dilakukan dokter untuk meredakan gejala dan mencegah penyebaran virus, yaitu:",
    "-Merujuk penderita COVID-19 yang berat untuk menjalani perawatan dan karatina di rumah sakit rujukan",
    "-Memberikan obat pereda demam dan nyeri yang aman",
    "-Menganjurkan penderita COVID-19 untuk melakukan isolasi mandiri dan istirahat yang cukup",
    "-Menganjurkan penderita COVID-19 untuk banyak minum air putih untuk menjaga kadar cairan tubuh"))

        listData2 = ArrayList()
        listData2.add(Home2("Diagnosis (COVID-19)",
        "Guna memastikan diagnosis COVID-19, dokter akan melakukan beberapa pemeriksaan berikut:",
        "Rapid test untuk mendeteksi antibodi (IgM dan IgG) yang diproduksi oleh tubuh untuk melawan virus Corona",
        "Swab test atau tes PCR (polymerase chain reaction) untuk mendeteksi virus Corona di dalam dahak",
        "CT scan atau Rontgen dada untuk mendeteksi infiltrat atau cairan di paru-paru,"))


    listData3 = ArrayList()
        listData3.add(Home3("Virus Corona atau severe acute respiratory syndrome coronavirus 2 (SARS-CoV-2) adalah virus yang menyerang sistem pernapasan. Penyakit karena infeksi virus ini disebut COVID-19. " +
                "Virus Corona bisa menyebabkan gangguan ringan pada sistem pernapasan, infeksi paru-paru yang berat, hingga kematian."))

    }

    private fun hasilData() {
        rv_home.layoutManager = LinearLayoutManager(activity)
        rv_home.adapter = HomeAdapter(activity!!, listData)

        rv_home2.layoutManager = LinearLayoutManager(activity)
        rv_home2.adapter = HomeAdapter2(activity!!, listData2)

        rv_home3.layoutManager = LinearLayoutManager(activity)
        rv_home3.adapter = HomeAdapter3(activity!!, listData3)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
