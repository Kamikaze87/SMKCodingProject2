package com.kamikaze.smkcodingproject2.dataclass


import com.google.gson.annotations.SerializedName

data class AttributesX(
    @SerializedName("Country_Region")
    val countryRegion: String,
    @SerializedName("Confirmed")
    val confirmed: Int,
    @SerializedName("Deaths")
    val deaths: Int,
    @SerializedName("Recovered")
    val recovered: Int,
    @SerializedName("Active")
    val active: Int,
    @SerializedName("Last_Update")
    val lastUpdate: Long,
    @SerializedName("Lat")
    val lat: Double,
    @SerializedName("Long_")
    val long: Double,
    @SerializedName("OBJECTID")
    val oBJECTID: Int
)