package com.kamikaze.smkcodingproject2.dataclass


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LokalData1Item(
    @SerializedName("meninggal")
    val meninggal: String,
    @SerializedName("positif")
    val positif: String,
    @SerializedName("sembuh")
    val sembuh: String
) : Serializable