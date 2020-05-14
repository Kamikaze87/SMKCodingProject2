package com.kamikaze.smkcodingproject2.data
import com.kamikaze.smkcodingproject2.dataclass.GlobalData
import retrofit2.Call
import retrofit2.http.GET

interface GlobalService {
    @GET("positif")
    fun getGlobal() : Call<List<GlobalData>>
}