package com.kamikaze.smkcodingproject2.data
import com.kamikaze.smkcodingproject2.dataclass.LokalData1Item
import com.kamikaze.smkcodingproject2.dataclass.ProvinsiItem
import com.kamikaze.smkcodingproject2.dataclass.TotalGlobalItem
import retrofit2.Call
import retrofit2.http.GET

interface LokalService1 {

    @GET("indonesia")
    fun getLokal() : Call<List<LokalData1Item>>

    @GET("indonesia/provinsi")
    fun getProvinsi() : Call<List<ProvinsiItem>>

    @GET(".")
    fun getGlobal() : Call<List<TotalGlobalItem>>
}