package com.kamikaze.smkcodingproject2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kamikaze.smkcodingproject2.adapter.GlobalAdapter
import com.kamikaze.smkcodingproject2.adapter.LokalAdapter1
import com.kamikaze.smkcodingproject2.data.GlobalService
import com.kamikaze.smkcodingproject2.data.apiRequest3
import com.kamikaze.smkcodingproject2.data.httpClient3
import com.kamikaze.smkcodingproject2.dataclass.GlobalData
import com.kamikaze.smkcodingproject2.dataclass.LokalData1Item
import com.kamikaze.smkcodingproject2.util.dismissLoad
import com.kamikaze.smkcodingproject2.util.hasilToast
import com.kamikaze.smkcodingproject2.util.showLoad
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_global.*
import kotlinx.android.synthetic.main.fragment_hospital.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GlobalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_global, container, false)
    }

    override fun onViewCreated(view: View,
                               @Nullable savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        callApiGlobal()
    }

    private fun callApiGlobal(){
        showLoad(context!!, swipeGlobal)

        val httpClient = httpClient3()
        val apiRequest = apiRequest3<GlobalService>(httpClient)

        val call = apiRequest.getGlobal()
        call.enqueue(object : Callback<List<GlobalData>> {

            override fun onFailure(call: Call<List<GlobalData>>, t: Throwable) {
                dismissLoad(swipeGlobal)
            }




            override fun onResponse(call: Call<List<GlobalData>>, response:
            Response<List<GlobalData>>
            ){
                dismissLoad(swipeGlobal)

                when {
                    response.isSuccessful ->

                        when {
                            response.body()?.size !=0 ->

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

    }




    private fun tampilLokalData(GlobalData1: List<GlobalData>) {
        rv_global.layoutManager = LinearLayoutManager(context)
        rv_global.adapter = GlobalAdapter(context!!, GlobalData1)
        {

            val GlobalData1 = it
            hasilToast(context!!, GlobalData1.name)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}


