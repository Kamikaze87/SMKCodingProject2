package com.kamikaze.smkcodingproject2.dataclass


import com.google.gson.annotations.SerializedName

data class TotalGlobalItem(
    @SerializedName("attributes")
    val attributes: AttributesX
)