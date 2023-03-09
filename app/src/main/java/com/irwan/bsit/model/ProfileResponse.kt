package com.irwan.bsit.model

import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @SerializedName("name")
    val name: String?,
    @SerializedName("joined_date")
    val joinedDate: String?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("no_telp")
    val noTelp: String?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lng")
    val lng: Double?,
)
