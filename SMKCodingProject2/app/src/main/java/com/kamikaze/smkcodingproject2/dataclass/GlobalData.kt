package com.kamikaze.smkcodingproject2.dataclass


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GlobalData(
    @SerializedName("name")
    val name: String,
    @SerializedName("value")
    val value: String
):Serializable