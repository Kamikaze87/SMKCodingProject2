package com.kamikaze.smkcodingproject2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kamikaze.smkcodingproject2.adapter.GlobalAdapter
import com.kamikaze.smkcodingproject2.data.*
import com.kamikaze.smkcodingproject2.dataclass.TotalGlobalItem
import com.kamikaze.smkcodingproject2.util.dismissLoad
import com.kamikaze.smkcodingproject2.util.hasilToast
import com.kamikaze.smkcodingproject2.util.showLoad
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_global.*
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


    private fun callApiGlobal() {
        showLoad(context!!, swipeGlobal)

        val httpClient = httpClient()
        val apiRequest = apiRequest<LokalService1>(httpClient)

        val call = apiRequest.getGlobal()
        call.enqueue(object : Callback<List<TotalGlobalItem>> {

            override fun onFailure(
                call: Call<List<TotalGlobalItem>>, t: Throwable
            ) {
                dismissLoad(swipeGlobal)
            }


            override fun onResponse(
                call: Call<List<TotalGlobalItem>>,
                response: Response<List<TotalGlobalItem>>
            ) {
                dismissLoad(swipeGlobal)

                when {
                    response.isSuccessful ->
                        when {
                            response.body()?.size != 0 ->
                                tampilGlobal(response.body()!!)
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

        private fun tampilGlobal(TotalGlobal: List<TotalGlobalItem>) {
            rv_global.layoutManager = LinearLayoutManager(context)
            rv_global.adapter = GlobalAdapter(context!!, TotalGlobal)
            {

                val TotalGlobal = it
                hasilToast(context!!, TotalGlobal.attributes.countryRegion)
            }
        }



    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}





