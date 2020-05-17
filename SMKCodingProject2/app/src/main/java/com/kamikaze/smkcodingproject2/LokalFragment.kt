package com.kamikaze.smkcodingproject2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kamikaze.smkcodingproject2.adapter.LokalAdapter1
import com.kamikaze.smkcodingproject2.adapter.ProvAdapter
import com.kamikaze.smkcodingproject2.data.*
import com.kamikaze.smkcodingproject2.dataclass.LokalData1Item
import com.kamikaze.smkcodingproject2.dataclass.ProvinsiItem
import com.kamikaze.smkcodingproject2.util.dismissLoad
import com.kamikaze.smkcodingproject2.util.hasilToast
import com.kamikaze.smkcodingproject2.util.showLoad
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_lokal.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LokalFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lokal, container, false)
    }

    override fun onViewCreated(
        view: View,
        @Nullable savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        callApiLokal()

    }

    private fun callApiLokal() {
        showLoad(context!!, swipeRefreshLokal)

        val httpClient = httpClient()
        val apiRequest = apiRequest<LokalService1>(httpClient)

        val call = apiRequest.getLokal()
        call.enqueue(object : Callback<List<LokalData1Item>> {

            override fun onFailure(
                call: Call<List<LokalData1Item>>, t: Throwable
            ) {
                dismissLoad(swipeRefreshLokal)
            }


            override fun onResponse
                        (call: Call<List<LokalData1Item>>,
                response: Response<List<LokalData1Item>>){
                dismissLoad(swipeRefreshLokal)

                when {
                    response.isSuccessful ->
                        when {
                            response.body()?.size != 0 ->
                                tampilLokalData(response.body()!!)
                            else -> {
                                hasilToast(context!!, "Berhasil")
                            }
                        }
                    else -> {
                        hasilToast(context!!, "Gagal")
                    }
                }
            }

        })



        val call2 = apiRequest.getProvinsi()
        call2.enqueue(object : Callback<List<ProvinsiItem>> {

            override fun onFailure(
                call: Call<List<ProvinsiItem>>, t: Throwable
            ) {
                dismissLoad(swipeRefreshLokal)
            }
            override fun onResponse
                        (call: Call<List<ProvinsiItem>>,
                         response: Response<List<ProvinsiItem>>){
                dismissLoad(swipeRefreshLokal)

                when {
                    response.isSuccessful ->

                        when {
                            response.body()?.size != 0 ->

                                tampilLokalData2(response.body()!!)

                            else -> {
                                hasilToast(context!!, "Berhasil")
                            }
                        }
                    else -> {
                        hasilToast(context!!, "Gagal")
                    }
                }
            }

        })
    }


    private fun tampilLokalData(lokalData1: List<LokalData1Item>) {
        listLokal1.layoutManager = LinearLayoutManager(context)
        listLokal1.adapter = LokalAdapter1(context!!, lokalData1)
        {

            val lokalData1 = it
            hasilToast(context!!, lokalData1.meninggal)
        }
    }

    private fun tampilLokalData2(Provinsi: List<ProvinsiItem>) {
        listLokal2.layoutManager = LinearLayoutManager(context)
        listLokal2.adapter = ProvAdapter(context!!, Provinsi)
        {

            val Provinsi = it
            hasilToast(context!!, Provinsi.attributes?.provinsi)
        }
    }


    override fun onDestroy() {
    super.onDestroy()
    this.clearFindViewByIdCache()
    }
}

