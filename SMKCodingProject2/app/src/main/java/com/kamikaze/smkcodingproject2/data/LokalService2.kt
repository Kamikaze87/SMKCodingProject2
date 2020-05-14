package com.kamikaze.smkcodingproject2.data

import com.kamikaze.smkcodingproject2.dataclass.LokalData2Item
import retrofit2.Call
import retrofit2.http.GET

interface LokalService2 {

    @GET("provinsi")
    fun getLokal2() : Call<List<LokalData2Item>>
}