package co.hidoc.infedisapp.data.models


import com.google.gson.annotations.SerializedName

data class ListPriceX(
    val amountInMicros: Int,
    val currencyCode: String
)