package com.kamikaze.smkcodingproject2.dataclass


import com.google.gson.annotations.SerializedName

data class ProvinsiItem(
    @SerializedName("attributes")
    val attributes: Attributes
)