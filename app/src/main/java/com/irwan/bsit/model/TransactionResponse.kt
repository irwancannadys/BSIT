package com.irwan.bsit.model

import com.google.gson.annotations.SerializedName

data class TransactionResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("image_url")
    val image_url: String?,
    @SerializedName("metode_trf")
    val metode_trf: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("nominal_saldo")
    val nominal_saldo: String?,
    @SerializedName("flag_debit_credit")
    val flag_debit_credit: Int?,
)
